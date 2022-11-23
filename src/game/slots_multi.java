package game;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 老虎机 找寻中奖的icon
 * 按数量中奖
 * 第一列必须有这个icon 而且 连续 n 列都有这个icon 即可判定这个 icon 中奖 再根据对应的 icon 数量的奖项配置计算奖金即可
 */

public class slots_multi {

    public static List<Map<String, Object>> findSameIconMulti(String[][] iconList, String wildIcon) {
        List<Map<String, Object>> result = new ArrayList<>(10);

        Map<String, Map<String, Object>> temp = new HashMap<>(16);
        // 直接记录第一列的icon信息
        for (int i = 0; i < iconList[0].length; i++) {
            Map<String, Object> item = new HashMap<>(4);
            item.put("exit_reel_nums", 1);
            List<Integer> reelIdx = new ArrayList<>(1);
            reelIdx.add(0);
            item.put("reel_idx", reelIdx);
            temp.put(iconList[0][i], item);
        }

        // 横向找寻相同的icon 先找出连续含有icon的 icon 和对应的 reel idx
        for (int i = 1; i < iconList.length; i++) {
            Map<String, Object> sameIcon = new HashMap<>(iconList[i].length);
            for (String s : iconList[i]) {
                sameIcon.put(s, i);
            }
            for (String key : sameIcon.keySet()) {
                if (temp.containsKey(key)){
                    Map<String, Object> objectMap = temp.get(key);
                    int nums = (int) objectMap.get("exit_reel_nums");
                    List<Integer> idx = (List<Integer>) objectMap.get("reel_idx");
                    if (nums >= i) {
                        objectMap.put("exit_reel_nums", nums+1);
                        idx.add((Integer) sameIcon.get(key));
                        objectMap.put("reel_idx", idx);
                        temp.put(key, objectMap);
                    }
                }
                // 万能icon 可以替换为任何icon
                if (key.equals(wildIcon)) {
                    for (String s : temp.keySet()) {
                        // 本次循环的列含有该icon 不再重复计算
                        if (sameIcon.containsKey(s)) {
                            continue;
                        }
                        Map<String, Object> objectMap = temp.get(s);
                        int nums = (int) objectMap.get("exit_reel_nums");
                        if (nums < i) {
                            continue;
                        }
                        List<Integer> idx = (List<Integer>) objectMap.get("reel_idx");
                        objectMap.put("exit_reel_nums", nums+1);
                        idx.add((Integer) sameIcon.get(key));
                        objectMap.put("reel_idx", idx);
                        temp.put(s, objectMap);
                    }
                }
            }
        }

        // 纵向查找 找寻每一个符合的icon 的 每一列的数量
        for (String icon : temp.keySet()) {
            Map<String, Object> objectMap = temp.get(icon);
            int nums = (int) objectMap.get("exit_reel_nums");
            if (nums < 2) {
                continue;
            }
            List<Integer> reelIdx = (List<Integer>) objectMap.get("reel_idx");
            List<List<Integer>> sList = new ArrayList<>(10);
            for (Integer idx : reelIdx) {
                List<Integer> lineIdx = new ArrayList<>(10);
                for (int i = 0; i < iconList[idx].length; i++) {
                    if (iconList[idx][i].equals(wildIcon) || iconList[idx][i].equals(icon)) {
                        lineIdx.add(i);
                    }
                }
                sList.add(lineIdx);
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("icon", icon);
            map.put("nums", nums);
            map.put("list", sList);
            result.add(map);
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] list = new String[][]{
                {"1004", "1201", "1005"}, {"1003", "1201", "1004", "1003"}, {"1201", "1201", "1008", "1007", "1002"},
                {"1101", "1201", "1006", "1003"}, {"1008", "1201", "1006"}
        };
        List<Map<String, Object>> sameIconMulti = findSameIconMulti(list, "1201");
        System.out.println(sameIconMulti);
    }

}
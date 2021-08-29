package 数据结构题库;

import java.util.*;

public class 两个数组的交集 {

    //利用map nums1放入map key是数组元素 value是该数组元素的数量
    //遍历nums2 判断元素是否在map中 在的同时 value>1 则value-1 value=1 则直接从map中remove该key
    public static int[] intersect(int[] nums1, int[] nums2) {
        //这层if算是个小优化 以短的数组来放入map 减少空间
        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>(nums1.length + nums2.length);
        for (int i : nums1) {
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 1){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }else if (map.containsKey(i) && map.get(i) == 1){
                list.add(i);
                map.remove(i);
            }
        }
        int [] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //做法2 先排序 直接双指针遍历
    //对比 小的那方指针后移
    //相等情况则放入结果数组 同时两个指针都向后移动
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0,index1 = 0,index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] > nums2[index2]){
                index2 ++;
            }else if (nums1[index1] < nums2[index2]){
                index1 ++;
            }else {
                res[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(res, 0 ,index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersect2(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}

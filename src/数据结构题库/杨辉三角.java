package 数据结构题库;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        List<Integer> list = new ArrayList<>(1);
        list.add(1);
        res.add(list);
        if (numRows == 1){
            return res;
        }
        for (int i = 2; i < numRows+1; i++) {
            if (res.get(i-2).size() < 2){
                List<Integer> list1 = new ArrayList<>();
                list1.add(1);
                list1.add(1);
                res.add(list1);
            }else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(1);
                for (int j = 0; j < i-2; j++) {
                    int temp = res.get(i-2).get(j) + res.get(i-2).get(j+1);
                    list1.add(temp);
                }
                list1.add(1);
                res.add(list1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }
}

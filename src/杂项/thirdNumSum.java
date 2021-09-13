package 杂项;

import java.util.ArrayList;
import java.util.List;

public class thirdNumSum {

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(10);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j+1 < nums.length; j++) {
                if (nums[i] + nums[j] + nums[j+1] == 0){
                    List<Integer> sumList = new ArrayList<>(3);
                    sumList.add(nums[i]);
                    sumList.add(nums[j]);
                    sumList.add(nums[j+1]);
                    List<List<Integer>> result1 = new ArrayList<>();
                    result1.add(sumList);
                    if (!result.containsAll(result1)){
                        result.add(sumList);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}

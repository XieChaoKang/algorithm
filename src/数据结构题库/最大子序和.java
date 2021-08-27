package 数据结构题库;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大子序和 {

    //暴力破解
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length < 2){
            return nums[0];
        }
        List<Integer> objects = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            objects.add(nums[i]);
            int temp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j; k > i ; k--) {
                    temp = temp + nums[k];
                }
                objects.add(temp);
                temp = nums[i];
            }
        }
        Object[] array = objects.toArray();
        Arrays.sort(array);
        int index = array.length > 1 ? array.length - 1 : 0;
        return (int) array[index];
    }

    //动态规划
    public static int maxSubArray1(int[] nums){
        int temp = 0, max = nums[0];
        for (int x : nums) {
            temp = Math.max(temp + x, x);
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{0}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{-1}));
        System.out.println(maxSubArray1(new int[]{-1000}));
        System.out.println(maxSubArray1(new int[]{-1000,1}));
    }
}

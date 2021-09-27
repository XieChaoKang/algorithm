package 数据结构题库;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 多数元素 {

    /**
     * 多数元素是指出现超过 n/2 次数的元素
     * @param nums
     * @return int
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public static void main(String[] args) {
        int[] nums = new  int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}

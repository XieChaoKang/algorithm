package 数据结构题库;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 17)));
    }
}

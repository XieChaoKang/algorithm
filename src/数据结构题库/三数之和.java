package 数据结构题库;

import java.util.*;

public class 三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>(nums.length);
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
        int[] nums1 = new int[]{-2,0,1,1,2};
        System.out.println(threeSum(nums1));
    }
}

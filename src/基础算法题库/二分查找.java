package 基础算法题库;

import java.util.Arrays;

public class 二分查找 {

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n = new int[]{-1,0,3,5,9,12};
        System.out.println(search(n, 3));
        System.out.println();
    }
}

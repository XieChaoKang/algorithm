package 杂项;

import java.util.Arrays;

public class 基数在前偶数在后 {

    /**
     * 前后指针
     * 前一个是基数 后一个是偶数是 两个指针同时后移
     * 前一个是偶数 后一个是基数 交换后 两个指针同时后移
     * 两个都是偶数时 后一个后移
     * @param nums
     */
    public static void sor(int[] nums){
        if (nums.length < 2){
            return;
        }
        int f = 0 , l = 1;
        while (f < l && l < nums.length){
            if (nums[f] % 2 != 0 && nums[l] % 2 == 0){
                f++;
                l++;
            }else if (nums[f] % 2 == 0 && nums[l] % 2 != 0){
                int temp = nums[f];
                nums[f] = nums[l];
                nums[l] = temp;
                f++;
                l++;
            }else {
                l++;
            }
        }
    }

    /**
     * 首尾指针
     * 同基 左指针往后移动
     * 同偶 右指针往前移动
     * 左偶右基 交换后 左右指针各自往后往前移动
     * 左基右偶 左右指针各自往后往前移动
     * @param nums
     */
    public static void sor1(int[] nums){
        if (nums.length < 2){
            return;
        }
        int l = 0, r = nums.length-1;
        while (l < r){
            if (nums[l]%2 != 0 && nums[r]%2 != 0){
                l++;
            }else if (nums[l]%2 == 0 && nums[r]%2 == 0){
                r--;
            }else if (nums[l]%2 == 0 && nums[r]%2 != 0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }else {
                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        sor(nums);
        System.out.println(Arrays.toString(nums));
        int[] nu = new int[]{4,2,1,3};
        sor1(nu);
        System.out.println(Arrays.toString(nu));
    }
}

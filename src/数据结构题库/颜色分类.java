package 数据结构题库;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */

public class 颜色分类 {

    //单指针
    public static void sortColors(int[] nums) {
        int index = 0;
        //先把0都换到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                ++index;
            }
        }
        //把1放到前面来
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                ++index;
            }
        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{};
        int[] n1 = new int[]{1};
        int[] n2 = new int[]{1,2};
        int[] n3 = new int[]{2,0,2,1,0,1};
        sortColors(n);
        sortColors(n1);
        sortColors(n2);
        sortColors(n3);
        System.out.println(Arrays.toString(n));
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println(Arrays.toString(n3));
    }
}

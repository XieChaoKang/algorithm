package 杂项;

import java.util.HashSet;
import java.util.Set;

public class 删除有序数组的重复项 {

    /**
     * 解法思路：双指针走法 f s
     * f一直往前移动 当f 所在位置的值和前面的一致时 f继续往前移动 s不动；当前f所在的位置的值和前面的不一致时，f的值覆盖s,同时f 和 s移动
     * 这样每当有重复的值的时候就会有后面的值不停的往前去覆盖
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums){
        if (nums == null || nums.length < 1)return 0;
        int f=1,s=1;
        while (f < nums.length){
            if (nums[f] != nums[f-1]){
                nums[s] = nums[f];
                ++s;
            }
            ++f;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{0,1,1,1,2,3};
        int i1 = removeDuplicates1(temp);
        for (int i = 0; i < i1; i++) {
            System.out.println(temp[i]);
        }
    }
}

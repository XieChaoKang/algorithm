package 杂项;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 给一组数组 求最大的容器体积
 * x * y
 * x:两个下标之差
 * y:两个下标对应的值中的小的那一个
 */

public class 最大容器体积 {

    /**
     * 暴力解法
     * 双重for循环
     * @param height //数组
     * @return
     */
    static int maxArea(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length-1; j > i; j--) {
                //两个下标对应的值的小的那个作为长度
                int height1 = Math.min(height[i], height[j]);
                //两个下标的差就是宽度
                int width = j - i;
                int product = width * height1;
                sum = Math.max(sum, product);
            }
        }
        return sum;
    }

    /**
     * 双指针做法
     * 1，先算出面积
     * 2，对比左右指针的值 小的那一方移动
     * 3，再次算出面积 取大的值
     * 4，循环该操作 直到左右指针重合
     * @param height //数组
     * @return
     */
    static int maxArea1(int[] height){
        //左右指针
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] integers = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(integers));
    }
}

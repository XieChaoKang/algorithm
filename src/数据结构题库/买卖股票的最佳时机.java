package 数据结构题库;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 买卖股票的最佳时机 {

    //暴力破解
    public static int maxProfit(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length < 2){
            return 0;
        }
        List<Integer> objects = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j; k > i ; k--) {
                    temp = nums[k] - temp;
                    if (temp > 0){
                        objects.add(temp);
                    }
                    temp = nums[i];
                }
            }
        }
        Object[] array = objects.toArray();
        if (array.length == 0){
            return 0;
        }else {
            Arrays.sort(array);
            int index = array.length > 1 ? array.length - 1 : 0;
            return (int) array[index];
        }
    }

    //暴力解法2
    public static int maxProfit2(int[] prices){
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                max = Math.max(temp, max);
            }
        }
        return max;
    }

    //动态规划
    //遍历 找到最低价格 然后后面的卖出价格来减 对比 找到最大利润返回
    public static int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else {
                max = Math.max((prices[i] - min), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit1(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit1(new int[]{6,7,1}));
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{7,6,4,3,1}));
    }
}

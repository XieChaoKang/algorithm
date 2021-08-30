package 数据结构题库;

import java.util.Arrays;

public class 重塑矩阵 {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int hang = nums.length; //行数
        int lie = nums[0].length; //列数

        //总的元素个数不一致时无法重塑
        if (hang * lie != r * c){
            return nums;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < hang * lie; ++i) {
            res[i/c][i%c] = nums[i/lie][i%lie];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
    }
}

package 数据结构题库;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class 旋转图像 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(t);
        System.out.println(Arrays.deepToString(t));
    }
}

package 数据结构题库;

import java.util.*;

public class 矩阵置零 {

    //思路：遍历一边 记录下矩阵为0的元素的行列位置 按顺序放入list 遍历list 替换对应的行列为0
    public static void setZeroes(int[][] matrix) {
        long start = System.currentTimeMillis() * 1000;
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                if (matrix[i][i1] == 0){
                    list.add(i);
                    list.add(i1);
                }
            }
        }
        for (int i = 0; i < list.size()-1; ) {
            int hang = matrix.length-1;
            int lie = matrix[0].length-1;
            while (lie > -1){
                matrix[list.get(i)][lie] = 0;
                lie --;
            }
            while (hang > -1){
                matrix[hang][list.get(i+1)] = 0;
                hang--;
            }
            i = i + 2;
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(System.currentTimeMillis() * 1000 - start);
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}

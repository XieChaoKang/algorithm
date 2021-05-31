package 排序算法;

/**
 * 冒泡算法的思想：
 * 每一趟排序找到对应的这一趟最小的数，放在对应的位置，比如第一趟找到第一小的数，放在第一位
 * 过程：
 * 1，第i趟遍历就需要找到第i小的数放在i的位置，因此外部循环就是遍历的次数，从前往后扫描，到倒数第二个元素即可，最后一个元素一定会是最大的
 * 2，第i趟循环时，前面i-1的数组是有序的，因此内部循环就是比较大小，从后往前扫描，直到i+1的位置即可
 */

public class 冒泡 {

    public static void bubbleSort(int[] list){
        int temp; //交换得临时数
        //外部循环 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            //相邻的树两两比较
            for (int j = list.length-1; j > i; j--) {
                if (list[j-1]>list[j]){
                    temp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = temp;
                }
            }
        }

        //排序后结果输出
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{1,3,7,2,8,4};
        bubbleSort(list);
    }
}

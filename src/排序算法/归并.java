package 排序算法;

import java.util.Arrays;

/**
 * 归并排序的思想：把数组分成n个1长度的数组，然后将相邻的两个序列合并成一个有序序列，得到n/2的序列，再继续相邻的两个合并成有序序列，直到得到一个长度为n的有序序列
 * 过程：
 * 1，从中间开始，分别从向左和向右递归分解
 * 2，合并
 * 注意：在合并中，将临时数组放入原本数组，不是每一次合并都是把拷贝全部的 画图理解
 * 如：第一次拷贝的是0，1；第二次拷贝的是2，3；第三次拷贝的是0，3；需要注意好i的值 因为i是原本数组的下标
 */
public class 归并 {

    /**
     * 两段序列进行合并
     * @param list //排序的数组
     * @param left //左边序列开始的位置
     * @param mid //中间值
     * @param right //
     */
    public static void Merge(int[] list,int left,int mid,int right){
        int i = left; //第一段数组的下标
        int j = mid+1; //第二段数组的下标
        int k = 0; //临时数组的下标
        int[] list2 = new int[right-left+1];

        //扫描两个数组 直到其中一个结束
        while (i<=mid && j<= right){
            //比较两个数组 小的放到临时数组中
            if (list[i] < list[j]){
                list2[k] = list[i];
                i++;
                k++;
            }else {
                list2[k] = list[j];
                j++;
                k++;
            }
        }

        //判断两段数组 哪一个在上一个循环中没扫描完就把该数组剩下的元素放入临时数组中
        while (i<=mid){
            list2[k] = list[i];
            i++;
            k++;
        }

        while (j<=right){
            list2[k] = list[j];
            j++;
            k++;
        }

        //将临时数组放入原本数组中
        //注意这里不是每次都拷贝全部的
        //画个图就能理解了 ：第一次拷贝的是0，1；第二次拷贝的是2，3；第三次拷贝的是0，3；因此需要注意好i的值 因为i是原本数组的下标
        for (k=0,i=left;i<=right;k++,i++){
            list[i] = list2[k];
        }
    }

    /**
     * 分+合并
     * @param list //待排序的数组
     */
    public static void Sort(int[] list,int left,int right){
        if (left < right){
            int mid = (left + right) / 2;
            //左边递归分解
            Sort(list,left,mid);
            //右边递归分解
            Sort(list,mid+1,right);
            //合并
            Merge(list,left,mid,right);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{1,3,7,2,8,4};
        Sort(list,0, list.length-1);
        System.out.println(Arrays.toString(list));
    }
}

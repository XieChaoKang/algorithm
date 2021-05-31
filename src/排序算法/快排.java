package 排序算法;

/**
 * 快排思想：一趟排序将数组分割为两半，左边的数永远比中间位置的数小，右边的数永远比中间的数大，然后再分别对左右两边的数组重复这一个操作
 * 过程：
 * 1，以数组最左边的数作为基准数
 * 2，从右往左扫描，直到找到比基准数小的数，放到最左边的位置
 * 3，从左往右扫描，直到找到比基准数大的数，放到最右边的位置
 * 4，重复2，3操作，直到左右指针重合，该位置即是基准数的位置
 * 5，对基准数左右两边的数组重复以上操作
 */

public class 快排 {

    public static int division(int[] list,int left,int right){
        int base = list[left];
        while (left < right){
            //从右往左遍历 直到找到比base还小的数 放到最左边
            while (left<right && list[right] >= base)
                right--;
            list[left] = list[right];

            //从左往右遍历 直到找到比base大的数 放到最右边
            while (left<right && list[left] <= base)
                left++;
            list[right] = list[left];
        }

        //base放到left位置 此时base左边的数都比base小 右边都比它大
        list[left] = base;
        return left;
    }

    public static void quickSort(int[] list,int left,int right){

        //防止越界
        if (left < right){
            //算是基准数的位置
            int baseIndex = division(list, left, right);

            //对基准数左边的数组递归排序
            quickSort(list,left,baseIndex-1);

            //对基准数右边的数组递归排序
            quickSort(list,baseIndex+1,right);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{1,3,7,2,8,4};
        quickSort(list,0, list.length-1);
        for (int j : list) {
            System.out.println(j);
        }
    }
}

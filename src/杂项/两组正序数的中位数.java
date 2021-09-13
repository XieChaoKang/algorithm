package 杂项;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 给定两个正序数组 找出中位数
 */
public class 两组正序数的中位数 {

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //无需排序 直接组合成一个数组进行查找中位数
        double sort = checkSort(nums1, nums2);
        if (sort > 0){
            return sort;
        }

        //拼接数组
        int[] list = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            list[i] = nums1[i];
        }
        //第二个数组拼接的起始位置
        int j = nums1.length;
        for (int i = 0;i < nums2.length;i++){
            list[j] = nums2[i];
            ++j;
        }

        //排序
        shellSort(list);

        //查找中位数
        int remainder = list.length % 2;
        int index = list.length / 2;
        if (remainder == 0){
            double sum = (list[index] + list[index-1]) / 2.0;
            return sum;
        }else {
            return list[index];
        }
    }

    /**
     * 判断两个数组是否拼接后不用排序就可以直接查找中位数
     * 考虑其中一个数组为空 则直接在另外一个数组里面进行求中位数
     * 不可能出现两个数组都为空的情况 该情况下是没有中位数的 所以不需要考虑该场景
     * @param nums1
     * @param nums2
     * @return
     */
    static double checkSort(int[] nums1, int[] nums2){
        CopyOnWriteArrayList<Integer> object1 = new CopyOnWriteArrayList<>();
        if (nums1.length == 0){
            for (int i: nums2) {
                object1.add(i);
            }
        }else if (nums2.length == 0){
            for (int i: nums1) {
                object1.add(i);
            }
        }else {
            if (nums1[nums1.length-1] <= nums2[0]){
                for (int i: nums1) {
                    object1.add(i);
                }
                for (int i: nums2) {
                    object1.add(i);
                }
            }else if (nums1[0] >= nums2[nums2.length-1]){
                for (int i: nums2) {
                    object1.add(i);
                }
                for (int i: nums1) {
                    object1.add(i);
                }
            }
        }

        if (object1.size() > 1){
            int remainder = object1.size() % 2;
            int index = object1.size() / 2;
            if (remainder == 0){
                double sum = (object1.get(index) + object1.get(index-1)) / 2.0;
                return sum;
            }else {
                return object1.get(index);
            }
        }else if (object1.size() == 1){
            return object1.get(0);
        }else {
            return 0;
        }
    }

    /**
     * 希尔排序 对拼接后的数组进行排序
     * @param list
     */
    static void shellSort(int[] list){
        int gap = list.length / 2;
        while (gap >= 1){
            for (int i = gap; i < list.length; i++) {
                int j = 0;
                int temp = list[i];
                for (j = i-gap;j>=0 && temp < list[j]; j = j-gap){
                    list[j+gap] = list[j];
                }
                list[j+gap]=temp;
            }
            gap = gap / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}

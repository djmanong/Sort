package cn.djmanong.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 11, 5, -1, 99, -10, 0, 25};
        System.out.println(Arrays.toString(quickSort(arr)));
    }

    /**
     * 快速排序
     * 平均时间复杂度：O(n log n)
     * 空间复杂度：O(log n)
     * 不稳定
     * @param sourceArr
     * @return
     */
    public static int[] quickSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(int[] arr, int left , int right) {

        // 设置左右指针
        int i = left;
        int j = right;

        // 设置基准值
        int pivot = arr[left];

        while (i < j) {

            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            // 元素与基准值相同
            if (arr[i] == arr[j] && i < j) {
                j--;
            } else {
                swap(arr, i, j);
            }
        }
        if (++i < right) {
            quickSort(arr, i, right);
        }
        if (--j > left) {
            quickSort(arr, left, j);
        }
    }

    /**
     * 交换数组两个元素的值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

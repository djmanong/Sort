package cn.djmanong.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {9, 11, 5, -1, 99, -10, 0, 25};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    /**
     * 归并排序
     * 平均时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     * 稳定
     * @param sourceArr
     * @return
     */
    public static int[] mergeSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

        return arr;
    }

    /**
     * 分解
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            mergeSort(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;

        // 中转数组索引
        int index = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        while (j <= right) {
            temp[index++] = arr[j++];
        }

        index = 0;
        while (left <= right) {
            arr[left++] = temp[index++];
        }
    }
}

package cn.djmanong.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {9, 11, 5, -1, 99, -10, 0, 25};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    /**
     * 选择排序
     * 平均时间复杂度: O(n^2)
     * 空间复杂度：O(1)
     * 不稳定
     * @param sourceArr
     * @return
     */
    public static int[] selectionSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        return arr;
    }

}

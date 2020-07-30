package cn.djmanong.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {9, 11, 5, -1, 99, -10, 0, 25};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    /**
     * 插入排序
     * 平均时间复杂度: O(n^2)
     * 空间复杂度：O(1)
     * 稳定
     * @param sourceArr
     * @return
     */
    public static int[] insertionSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        for (int i = 0; i < arr.length - 1; i++) {

            int j = i + 1;
            int temp = arr[j];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i + 1) {
                arr[j] = temp;
            }
        }

        return arr;
    }

}

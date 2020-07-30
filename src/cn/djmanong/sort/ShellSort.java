package cn.djmanong.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {9, 11, 5, -1, 99, -10, 0, 25};
        System.out.println(Arrays.toString(shellSort(arr)));
    }

    /**
     * 希尔排序
     * 平均时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     * 不稳定
     * @param sourceArr
     * @return
     */
    public static int[] shellSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                if (j != i) {
                    arr[j] = temp;
                }
            }
            System.out.println("希尔排序第" + ++count + "趟的结果：" + Arrays.toString(arr));
        }

        return arr;
    }
}

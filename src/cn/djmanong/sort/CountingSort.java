package cn.djmanong.sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] arr = {999, 1000, 7, 0, 97, 50, 1024, 3306};
        System.out.println(Arrays.toString(countingSort(arr)));
    }

    /**
     * 计数排序 : 这里以非负整数为例 (若存在负数，可将待排序列分为负整数和非负整数两个序列进行计数排序)
     * 时间复杂度：O(n + k)  (k为整数的范围)
     * 空间复杂度：O(k)
     * 稳定性：稳定
     * @param sourceArr
     * @return
     */
    public static int[] countingSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        // 获取最大值
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }

        // 创建一个长度为 max + 1 的数组，用来记录每个值出现的次数
        int[] temp = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < temp.length; i++) {

            if (temp[i] > 0) {
                for (int j = 0; j < temp[i]; j++) {
                    arr[index++] = i;
                }
            }

        }

        return arr;
    }
}

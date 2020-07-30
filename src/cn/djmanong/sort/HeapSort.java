package cn.djmanong.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {9, 11, 5, -1, 99, -10, 0, 25};
        System.out.println(Arrays.toString(heapSort(arr)));
    }

    /**
     * 堆排序: 构建大顶堆 / 小顶堆 (完全二叉树)
     * 平均时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     * 不稳定
     * @param sourceArr
     * @return
     */
    public static int[] heapSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        for (int length = arr.length; length > 1; length--) {
            // 最后一个非叶子节点
            int node = length / 2 - 1;

            heapSort(arr, node, length);

            System.out.println(Arrays.toString(arr));

            // 每一趟大顶堆构建完成，交换首尾元素
            swap(arr, 0, length - 1);
        }

        return arr;
    }

    /**
     * 大顶堆的构建
     * @param arr    原数组
     * @param node   最后一个非叶子节点
     * @param length 待操作序列的长度
     */
    public static void heapSort(int[] arr, int node, int length) {

        while (node >= 0) {

            // 左、右孩子节点
            int left = 2 * node + 1;
            int right = 2 * node + 2;

            // 记录最大值
            int max = node;

            if (left < length && arr[max] < arr[left]) {
                max = left;
            }
            if (right < length && arr[max] < arr[right]) {
                max = right;
            }

            if (max != node) {
                swap(arr, max, node);

                // 值交换完毕后可能会对后面的非叶子节点产生影响，需要做递归处理
                heapSort(arr, max, length);
            }

            node--;
        }
    }

    /**
     * 交换两个元素的值
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

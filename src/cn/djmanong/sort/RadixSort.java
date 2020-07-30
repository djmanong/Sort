package cn.djmanong.sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {

        int[] arr = {1, 11, 5, 11, 39, 10, 0, 25};
        System.out.println(Arrays.toString(radixSort(arr, 10)));
    }

    /**
     * 基数排序
     * 时间复杂度：O(n * k)
     * 空间复杂度：O(n + k)
     * 稳定性：稳定
     * @param sourceArr
     * @return
     */
    public static int[] radixSort(int[] sourceArr, int d) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        // 用来取每个数某位上的值
        int n = 1;

        // 数组长度
        int length = arr.length;

        // 保存每次排序的结果 某个位上的值相同则放入二维数组同一个位置上
        // 10个桶 某位上的匹配的值相同则放入同一个桶中
        int[][] temp = new int[10][length];

        // 统计每个桶中元素的个数
        int[] count = new int[10];

        while (n <= d) {

            for (int i : arr) {
                // 取某位上的值
                int place = i / n % 10;
                // 添加到对应的桶中
                temp[place][count[place]++] = i;
            }

            // 遍历二维数组取值
            int index = 0;
            for (int i = 0; i < 10; i++) {
                // 验证是否有数据
                if (count[i] > 0) {
                    for (int j = 0; j < count[i]; j++) {
                        arr[index++] = temp[i][j];
                    }
                }
                count[i] = 0;
            }

            n *= 10;
        }

        return arr;
    }
}

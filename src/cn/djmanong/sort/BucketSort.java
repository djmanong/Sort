package cn.djmanong.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class BucketSort {

    public static void main(String[] args) {

        int[] arr = {1000, 9, 11, 5, -1, 99, -10, 0, 25, -1000};
        System.out.println(Arrays.toString(bucketSort(arr)));
    }

    /**
     * 桶排序
     * 时间复杂度：O(n + k)
     * 空间复杂度：O(n + k)
     * 稳定性：稳定
     * @param sourceArr
     * @return
     */
    public static int[] bucketSort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        // 获取最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }

        // 设置桶的个数
        int num = 5;

        // 每个桶的范围 (+1防止最大值溢出)
        double space =  (double) (max - min + 1) / num;
        // double space = Math.floor((max - min) / num) + 1;

        // 创建桶 这里使用链表创建桶，也可以使用二维数组等方法
        LinkedList<Integer>[] list = new LinkedList[num];

        for (int i = 0; i < arr.length; i++) {

            // 找到对应的桶
            int index = (int) ((arr[i] - min) / space);

            if (list[index] == null) {
                list[index] = new LinkedList<Integer>();
            }

            // 将元素添加进桶中，并对桶中的元素进行排序，这里使用插入排序
            list[index].add(arr[i]);

            for (int j = 0; j < list[index].size() - 1; j++) {
                int k = j + 1;
                int temp = list[index].get(k);
                while (k > 0 && temp < list[index].get(k - 1)) {
                    list[index].set(k, list[index].get(k - 1));
                    k--;
                }
                if (k != j + 1) {
                    list[index].set(k, temp);
                }
            }

        }

        // 遍历合并非空桶
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                for (int j = 0; j < list[i].size(); j++) {
                    arr[index++] = list[i].get(j);
                }
            }
        }

        return arr;

    }
}

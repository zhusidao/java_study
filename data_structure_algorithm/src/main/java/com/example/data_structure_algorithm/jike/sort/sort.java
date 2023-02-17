package com.example.data_structure_algorithm.jike.sort;


import java.util.Arrays;
import java.util.Collections;

/**
 * 比如我们有一组数据 2，9，3，4，8，3，按照大小排序之后就是 2，3，3，4，8，9。
 * 这组数据里有两个3。经过某种排序算法排序之后，如果两个3的前后顺序没有改变，那我们就把这种排序算法叫作
 */
public class sort {
    /**
     * {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
     * {3, 5, 2, 7, 6, 4, 1};
     * {11, 8, 3, 9, 7, 1, 2, 5};
     */
    private static int[] numbers = {11, 8, 3, 9, 7, 1, 2, 5}; //{2, 5, 3, 0, 2, 3, 0, 3};


    private static void maopao1(int[] numbers) {
        int k = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    k = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = k;
                }
            }
            System.out.println(Arrays.toString(numbers));
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 3 5 2 7 6 4 1
     * 一: 3 2 5 6 4 1 7
     * 二: 2 3 5 4 1 6 7
     * 三: 2 3 4 1 5 6 7
     * 四: 2 3 1 4 5 6 7
     * 五: 2 1 3 4 5 6 7
     * 六: 1 2 3 4 5 6 7
     * 七: 1 2 3 4 5 6 7
     * <p>
     * 稳定排序
     * <p>
     * 最好时间复杂度O(n)
     * 最差时间复杂度O(n^2)
     */
    private static void maopao2(int[] numbers) {
        int k;
        boolean isOrder;
        for (int i = 0; i < numbers.length; i++) {
            isOrder = true;
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    k = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = k;
                    isOrder = false;
                }
            }
            System.out.println(Arrays.toString(numbers));
            if (isOrder) {
                break;
            }
        }
    }

    /**
     * 插入排序（类比数组的插入算法）
     * <p>
     * 3 5 2 7 6 4 1
     * 左边("[]"中)是有序，右边是无序；有序集合和右边第一个无序集合进行比较，大于则向后移动，这样才能腾出位置给元素无序元素插入。
     * ()中为将要排序的数字
     * 一:[3] (5) 2 7 6 4 1
     * 一:[3 5] (2) 7 6 4 1
     * 二:[2 3 5] (7) 6 4 1
     * 三:[2 3 5 7] (6) 4 1
     * 四:[2 3 5 6 7] (4) 1
     * 五:[2 3 4 5 6 7] (1)
     * 六:[1 2 3 4 5 6 7]
     * <p>
     * 稳定排序
     *
     * <p>
     * 最好时间复杂度O(n)
     * 平均时间复杂度O(n^2)
     * 最差时间复杂度O(n^2)
     */
    private static void insert(int[] numbers) {
        int k;
        // 无序集合
        for (int i = 1; i < numbers.length; i++) {
            k = numbers[i];
            int j = i - 1;
            // 有序集合
            for (; j >= 0; j--) {
                if (numbers[j] > k) {
                    numbers[j + 1] = numbers[j];
                    continue;
                }
                break;
            }
            numbers[j + 1] = k;
            System.out.println(Arrays.toString(numbers));
        }
    }

    /**
     * 选择排序
     * <p>
     * 3 5 2 7 6 4 1
     * 左边("[]"中)是有序，右边是无序；无序集合中选出一个最小的，依次对有序集合进行填充。
     * 一:[1] 5 2 7 6 4 3
     * 二:[1 2] 5 7 6 4 3
     * 三:[1 2 3] 7 6 4 5
     * 四:[1 2 3 4] 6 7 5
     * 五:[1 2 3 4 5] 7 6
     * 六:[1 2 3 4 5 6 7]
     * <p>
     * 不稳定
     * <p>
     * 最好时间复杂度O(n^2)
     * 平均时间复杂度O(n^2)
     * 最差时间复杂度O(n^2)
     */
    private static void select(int[] numbers) {
        int swap;
        // 有序集合
        for (int i = 0; i < numbers.length - 1; i++) {
            // 无序集合
            int min = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[min] > numbers[j]) {
                    min = j;
                }
            }
            swap = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = swap;
            System.out.println(Arrays.toString(numbers));
        }
    }

    /**
     * 希尔排序
     * <p>
     * 9 1 2 5 7 4 8 6 3 5
     * 分组排序插入排序
     * 一:4 1 2 3 5 9 8 6 5 7
     * 二:2 1 4 3 5 6 5 7 8 9
     * 三:1 2 3 4 5 5 6 7 8 9
     * <p>
     * 不稳定
     * <p>
     * 最好时间复杂度O(n)
     * 平均时间复杂度O(n^m(m>1<2))
     * 最差时间复杂度O(n^2)
     *
     * @param numbers
     */
    public static void shell(int[] numbers) {
        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < numbers.length; i++) {
                int tmp = numbers[i];
                int j = i - gap;
                for (; j >= 0 && tmp < numbers[j]; j = j - gap) {
                    numbers[j + gap] = numbers[j];
                }
                numbers[j + gap] = tmp;
            }
            System.out.println(Arrays.toString(numbers));
        }
    }

    /**
     * 归并排序
     * <p>
     * 11 8 3 9 7 1 2 5
     * <p>
     * 分解
     * 分组第一次: (11 8 3 9) (7 1 2 5)
     * 分组第二次: ((11 8) (3 9)) ((7 1) (2 5))
     * 分组第三次: ((((11）(8)) ((3) (9))) (((7) (1)) ((2) (5))))
     * <p>
     * 合并
     * 第一次合并: ((8 11) (3 9)) ((1 7) (2 5))
     * 第二次合并: (3 8 9 11) (1 2 5 7)
     * 第三次合并: 1 2 3 5 7 8 9 11
     * <p>
     * 最好时间复杂度O(nlogn)
     * 平均时间复杂度O(nlogn)
     * 最差时间复杂度O(nlogn)
     * <p>
     * 稳定排序
     * <p>
     * 空间复杂度为O(n)
     *
     * @param numbers
     */
    public static void merge(int[] numbers, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = (start + end) / 2;
        merge(numbers, tmp, start, index);
        merge(numbers, tmp, index + 1, end);
        combine(numbers, tmp, start, index + 1, end);
    }

    /**
     * 双端快排
     * 11 8 3 9 7 1 2 5
     * 一:(11) 5 8 3 9 7 1 2 | 11
     * 二:(5)  2 1 3 | 5 | 7 9 8
     * 三:(2)  1 | 2 | 3 | 5 | (7) 7 | 9 8
     * 四:1 2 3 5 7  (9) 8 9
     * <p>
     * 不稳定
     * 最好时间复杂度O(nlogn)
     * 平均时间复杂度O(nlogn)
     * 最差时间复杂度O(n^2)
     */
    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int standard = a[start];
        System.out.println("standard = " + standard);
        int i = start, j = end;
        while (j > i) {
            while (a[j] >= standard && j > i) {
                j--;
            }
            if (j > i) {
                a[i++] = a[j];
            }
            while (a[i] <= standard && j > i) {
                i++;
            }
            if (j > i) {
                a[j--] = a[i];
            }
        }
        a[i] = standard;
        System.out.println(Arrays.toString(a));
        quickSort(a, start, j - 1);
        quickSort(a, j + 1, end);
    }

    /**
     * 双端快排交换
     * 11 8 3 9 7 1 2 5
     * 一:(11) 5 8 3 9 7 1 2 | 11
     * 二:(5)  5 2 3 1 7 9 8 | 11
     * 三:(1)  1 2 3 | 5 | (7) 7 9 8 ｜ 11
     * 四:(2)  1 | 2 | 3 | 5 | 7 | (9) 8 | 9 | 11
     * <p>
     * 不稳定
     */
    private static void quickSort1(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int standard = a[start];
        System.out.println("standard = " + standard);
        int i = start, j = end;
        while (j > i) {
            while (a[j] >= standard && j > i) {
                j--;
            }
            while (a[i] <= standard && j > i) {
                i++;
            }
            if (j > i) {
                swap(a, i, j);
            }
        }
        swap(a, start, i);
        System.out.println(Arrays.toString(a));
        quickSort1(a, start, j - 1);
        quickSort1(a, j + 1, end);
    }

    /**
     * 快排交换
     * 11 8 3 9 7 1 2 5
     * 一:(11) 5 8 3 9 7 1 2 | 11
     * 二:(5)  5 2 3 1 7 9 8 | 11
     * 三:(1)  1 2 3 | 5 | (7) 7 9 8 ｜ 11
     * 四:(2)  1 | 2 | 3 | 5 | 7 | (9) 8 | 9 | 11
     * <p>
     * 不稳定
     */
    private static void quickSort2(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int standard = a[end];
        System.out.println("standard = " + standard);
        int i = start;
        for (int j = start; j < end; j++) {
            if (standard > a[j]) {
                if (i == j) {
                    i++;
                } else {
                    swap(a, i++, j);
                }
            }
        }
        swap(a, end, i);
        System.out.println(Arrays.toString(a));
        quickSort2(a, start, i - 1);
        quickSort2(a, i + 1, end);
    }

    private static void swap(int[] a, int index, int index2) {
        int tmp = a[index];
        a[index] = a[index2];
        a[index2] = tmp;
    }

    private static void combine(int[] a, int[] tmp, int left, int center, int right) {
        int tmpLength = right - left + 1;
        int tmpPos = left;
        for (int i = 0; i < tmpLength; i++) {
            //只拷贝当前 merge 的部分数组
            tmp[right - i] = a[right - i];
        }
        while (tmpPos <= right) {
            if (center > right || (left < center && tmp[left] < tmp[center])) {
                a[tmpPos++] = tmp[left++];
            } else {
                a[tmpPos++] = tmp[center++];
            }
        }
        // print
        for (int i = 1; i <= tmpLength; i++) {
            System.out.print(a[right - tmpLength + i] + " ");
        }
        System.out.println();
    }

    private static void combine1(int[] a, int[] tmp, int left, int center, int right) {
        int leftEnd = center - 1;
        int tmpLength = right - left + 1;
        int tmpPos = left;
        while (left <= leftEnd && center <= right) {
            if (a[left] > a[center]) {
                tmp[tmpPos++] = a[center++];
            } else {
                tmp[tmpPos++] = a[leftEnd++];
            }
        }
        while (left <= leftEnd) {
            tmp[tmpPos++] = a[left++];
        }
        while (right <= leftEnd) {
            tmp[tmpPos++] = a[right++];
        }
        for (int i = 0; i < tmpLength; i++) {
            // 只拷贝当前 merge 的部分数组
            a[right - i] = tmp[right - i];
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 技术排序
     *
     * @param a
     */
    public static void countingSort(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        int[] count = new int[max + 1];
        // 统计个数
        for (int j : a) {
            count[j]++;
        }
        // 统计位置
        for (int i = 1; i <= max; i++) {
            count[i] = count[i] + count[i - 1];
        }
        int[] result = new int[a.length];
        // 倒序取值稳定
        for (int j = a.length - 1; j >= 0; j--) {
            // 获取下标
            result[--count[j]] = j;
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        shell(numbers);
    }

}

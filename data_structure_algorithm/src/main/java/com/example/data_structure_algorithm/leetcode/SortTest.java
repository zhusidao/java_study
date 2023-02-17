package com.example.data_structure_algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/13
 */
public class SortTest {
    /**
     * 4，5，6，1，3，2
     *
     * @param args
     */
    public static void main(String[] args) {
/*        int[] a = {5, 4, 3, 2, 1};
        mergeSort(a, 0, 4);
        System.out.println(Arrays.toString(a));*/
        int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        shell(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     */
    public static int[] insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int v = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (v < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = v;
        }
        return a;
    }

    /**
     * 冒泡排序
     *
     * @param a
     */
    public static int[] bubbleSort(int[] a) {
        int tmp;
        for (int i = 0; i < a.length - 1; i++) {
            boolean hasNoChange = true;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    hasNoChange = false;
                }
            }
            if (hasNoChange) {
                break;
            }
        }
        return a;
    }

    /**
     * 选择排序
     */
    public static int[] selectSort(int[] a) {
        int tmp;
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j + 1;
                }
            }
            tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
        return a;
    }

    /**
     * 快排1
     *
     * @param a
     * @param start
     * @param end
     */
    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int tag = a[start];
        while (i < j) {
            while (a[j] >= tag && i < j) {
                j--;
            }
            while (a[i] <= tag && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[start] = a[i];
        a[i] = tag;
        quickSort(a, start, i - 1);
        quickSort(a, i + 1, end);
    }

    /**
     * @param a
     * @param start
     * @param end
     */
    public static void quickSort1(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int tag = a[start];
        while (i < j) {
            while (a[j] >= tag && i < j) {
                j--;
            }
            a[start] = a[j];
            while (a[i] <= tag && i < j) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = tag;
        quickSort(a, start, i - 1);
        quickSort(a, i + 1, end);

    }

    /**
     * 归并排序
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int position = (start + end) / 2;
        mergeSort(a, start, position);
        mergeSort(a, position + 1, end);

        merge(a, start, position + 1, end);

    }

    public static int[] merge(int[] a, int start, int pos, int end) {
        System.out.println("start=" + start + " pos=" + pos + " end=" + end);
        int index = start;
        int startEnd = pos - 1;
        int[] tmp = new int[end - start + 1];
        int j = 0;
        while (start <= startEnd && pos <= end) {
            if (a[start] < a[pos]) {
                tmp[j++] = a[start++];
            } else {
                tmp[j++] = a[pos++];
            }
        }
        if (start - 1 == startEnd) {
            while (pos <= end) {
                tmp[j++] = a[pos++];
            }
        }
        if (pos - 1 == end) {
            while (start <= startEnd) {
                tmp[j++] = a[start++];
            }
        }
        if (tmp.length >= 0) {
            System.arraycopy(tmp, 0, a, index, tmp.length);
        }
        return tmp;
    }


    /**
     * 基数排序
     *
     * @param a
     * @return
     */
    public static int[] countSort(int[] a) {
        int max = Arrays.stream(a).max().getAsInt();
        int[] tmp = new int[max + 1];
        for (int i : a) {
            tmp[i]++;
        }
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = tmp[i] + tmp[i - 1];
        }
        int[] result = new int[a.length];
        for (int j : a) {
            result[tmp[j] - 1] = j;
            tmp[j]--;
        }
        return result;
    }


    public static void shell(int[] a) {
        for (int len = a.length / 2; len > 0; len /= 2) {
            for (int i = len; i < a.length; i = i + len) {
                int tmp = a[i];
                int j = i - len;
                for (; j >= 0 && tmp < a[j]; j = j - len) {
                    a[j + len] = a[j];
                }
                a[j + len] = tmp;
            }
        }
    }
}

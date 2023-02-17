package com.example.data_structure_algorithm.jike.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: sidao.zhu
 * @Date: 2021/3/5
 */
public class HeapTest {


    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public HeapTest(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入
     * 从下网上堆化
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return; // 堆满了
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
            swap(a, i, i / 2); // swap()函数作用：交换下标为i和i/2的两个元素
            i = i / 2;
        }
    }

    /**
     * 我的删除
     * <p>
     * 从上往下
     */
    public Integer poll() {
        if (count < 1) {
            return null; // 空了
        }
        int result = a[1];
        a[1] = a[count--];
        myHeapify(1);
        return result;
    }

    /**
     * 我的构堆
     */
    public void buildHeap() {
        for (int i = count / 2; i > 0; i--) {
            myHeapify(i);
        }
    }

    /**
     * 至上而且进行堆化
     * @param current
     */
    void myHeapify(int current) {
        int tmp;
        while (current * 2 <= count) {
            tmp = current * 2;
            if (tmp + 1 <= count && a[tmp] < a[tmp + 1]) {
                tmp = tmp + 1;
            }
            if (a[current] >= a[tmp]) {
                break;
            }
            swap(a, current, tmp); // swap()函数作用：交换下标为i和i/2的两个元素
            current = tmp;

        }
    }

    /**
     * 删除堆顶元素
     *
     * @return
     */
    public boolean removeMax() {
        if (count == 0) {
            return false; // 堆中没有数据
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
        return true;
    }

    /**
     * 自上往下堆化
     *
     * @param a
     * @param n
     * @param i
     */
    private static void heapify(int[] a, int n, int i) { //
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 我们对下标从 n/2 开始到 1 的数据进行堆化，下标是 n/2+1 到 n 的节点是叶子节点，我们不需要堆化。
     * 实际上，对于完全二叉树来说，下标从 n/2+1 到 n 的节点都是叶子节点。
     *
     * @param a
     * @param n
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    // n表示数据的个数，数组a中的数据从下标1到n的位置。
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    private static void swap(int[] a, int index, int index2) {
        int tmp = a[index];
        a[index] = a[index2];
        a[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {-1, 10, 2, 8, 5, 4, 7, 9};
 /*       sort(a, a.length - 1);
        System.out.println(Arrays.toString(a));*/
/*        PriorityQueue<Integer> queue = new PriorityQueue<>();
        System.out.println(queue.poll());*/
/*        HeapTest heapTest = new HeapTest(7);
        heapTest.insert(11);
        heapTest.insert(7);
        heapTest.insert(9);
        heapTest.insert(66);
        heapTest.insert(1);
        heapTest.insert(8);
        heapTest.insert(40);*/

  /*      Integer val;
        while ((val = heapTest.poll()) != null) {
            System.out.println(val);
        }*/
        HeapTest heapTest = new HeapTest(a.length);
        heapTest.count = a.length;
        System.arraycopy(a, 0, heapTest.a, 1, a.length);
        heapTest.buildHeap();

        Integer val;
        while ((val = heapTest.poll()) != null) {
            System.out.println(val);
        }
    }

}

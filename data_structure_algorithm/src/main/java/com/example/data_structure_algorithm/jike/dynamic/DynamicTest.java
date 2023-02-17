package com.example.data_structure_algorithm.jike.dynamic;

/**
 * 动态规划
 *
 * @Author: sidao.zhu
 * @Date: 2021/3/19
 */
public class DynamicTest {
    private int[] weight = {2, 2, 4, 6, 3}; // 物品重量
    private int[] values = {1, 3, 8, 4, 5}; // 物品价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    // weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    public int myKnapsack(int[] weight, int[] values, int n, int w) {
        int[][] tb = new int[n][w + 1];
        for (int j = 0; j <= w; j++) {
            if (weight[0] <= j) {
                tb[0][j] = values[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j - weight[i] >= 0 && values[i] + tb[i - 1][j - weight[i]] > tb[i - 1][j]) {
                    // 装入大于不装入
                    tb[i][j] = values[i] + tb[i - 1][j - weight[i]];
                } else {
                    tb[i][j] = tb[i - 1][j];
                }
            }
        }
        return tb[n - 1][w];
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i-1][j] >= 0) {
                    states[i][j] = states[i-1][j];
                }
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) {
                maxvalue = states[n-1][j];
            }
        }
        return maxvalue;
    }

    public static void main(String[] args) {
        DynamicTest dynamicTest = new DynamicTest();
        System.out.println(dynamicTest.myKnapsack(dynamicTest.weight, dynamicTest.values, dynamicTest.n, dynamicTest.w));
    }
}

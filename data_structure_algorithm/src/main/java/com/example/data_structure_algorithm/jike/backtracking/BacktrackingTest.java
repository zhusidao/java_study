package com.example.data_structure_algorithm.jike.backtracking;

/**
 * @Author: sidao.zhu
 * @Date: 2021/3/12
 */
public class BacktrackingTest {

    /**
     * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
     * 递归实现回溯
     */

    int[] result = new int[8];//全局或成员变量,下标表示行,值表示queen存储在哪一列

    public void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8行棋子都放好了，已经没法再往下递归了，所以就return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有8中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第row行的棋子放到了column列
                cal8queens(row+1); // 考察下一行
            }
        }
    }

    private boolean isOk(int row, int column) {//判断row行column列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row-1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) {
                return false; // 第i行的column列有棋子吗？
            }
            if (leftup >= 0) { // 考察左上对角线：第i行leftup列有棋子吗？
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8) { // 考察右上对角线：第i行rightup列有棋子吗？
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup; ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值

    /**
     * 01背包
     * 找最大能放入的值
     *
     * @param i
     * @param cw
     * @param items
     * @param n
     * @param w
     */
    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public static void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {
        BacktrackingTest test = new BacktrackingTest();
        //     f(0, 0, new int[]{10, 22, 30, 40, 35, 32}, 6, 100);
        //   System.out.println(maxW);
        test.cal8queens(0);
    }
}

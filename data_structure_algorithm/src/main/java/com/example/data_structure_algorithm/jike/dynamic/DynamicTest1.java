package com.example.data_structure_algorithm.jike.dynamic;

/**
 * 动态规划
 *
 * @Author: sidao.zhu
 * @Date: 2021/3/19
 */
public class DynamicTest1 {
    int[][] a = new int[][]{{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
    int min = Integer.MAX_VALUE;

    /**
     * 回溯实现动态规划
     *
     * @param i
     * @param j
     * @param current
     */
    private void go(int i, int j, int current) {
        if (i == 3 && j == 3) {
            if (min > current) {
                min = current;
            }
        }
        if (j < 3) {
            go(i, j + 1, a[i][j + 1] + current);
        }
        if (i < 3) {
            go(i + 1, j, a[i + 1][j] + current);
        }
    }

    private void minDistDP() {
        for (int i = 1; i < 4; i++) {
            a[i][0] = a[i - 1][0] + a[i][0];
            a[0][i] = a[0][i - 1] + a[0][i];
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                a[i][j] = Math.min(a[i - 1][j], a[i][j - 1]) + a[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DynamicTest1 dynamicTest1 = new DynamicTest1();
   //     dynamicTest1.go(0, 0, dynamicTest1.a[0][0]);
     //   System.out.println(dynamicTest1.min);

        dynamicTest1.minDistDP();
    }
}

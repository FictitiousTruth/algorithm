package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/12 12:43
 * @注释 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 */
public class LC62 {
    /**
     * 机器人每次只能向下或者向右移动
     * 棋盘中的格子一定是通过上一个得来的
     * 使用二维数组 利用动态规划算法来解题
     * 默认要初始化第一行和第一列的值
     * 递推公式 dp[i][j]=dp[i-1][j]+dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
}

package com.study.practice.leetcodeTop100;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * 《最大正方形》
 */
public class LC221 {
    public static int maximalSquare(char[][] matrix) {
        // 矩阵的长宽
        int length = matrix[0].length;
        int width = matrix.length;
        /**
         * 定义动态数组 dp
         *  dp[i][j] 表示的含义是 以i,j为边的只含1的正方形的边长
         */
        int[][] dp = new int[width][length];
        // 以dp[i][j]为右下角围成的只包含1的正方形的边长
        int a = 0;

        /**
         * 初始化dp数组 : 第一行和第一列
         * 第一行和第一列的值如果当前行或者列中方格里面的值是0 那么dp[i][j]=0
         *                 如果当前行或者列中方格里面的值是1 那么dp[i][j]=1
         *
         *  !!!注意 matrix[i][j]=='0' √
         *  !!!注意 matrix[i][j]==0  ×
         *  matrix 里面是字符型的
         */
        for (int i = 0; i < length; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            a = Math.max(dp[0][i], a);
        }
        for (int j = 0; j < width; j++) {
            dp[j][0] = matrix[j][0] == '0' ? 0 : 1;
            a = Math.max(dp[j][0], a);
        }
        /**
         * dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
         */
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < length; j++) {
                if (matrix[i][j] != '0') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                a = Math.max(dp[i][j], a);
            }
        }
        // a*a=面积
        return a * a;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0'}};
        System.out.println(maximalSquare(matrix));
    }
}

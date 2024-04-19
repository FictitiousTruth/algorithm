package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/12 12:57
 * @注释: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物1
 * 空位置 0
 *
 * <p>
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class LC63 {

    /**
     * 本题和LC62题相似
     * 不同的点是： 如果此障碍物在第一行和第一列的时候 碰到障碍物的时候 是后面的格式是直接无法触及的 此时设置dp[i][j]就不是1 而要赋值为0
     * 如果该障碍物不是位于第一行和第一列 对后面的格子是没有影响的 只要将有障碍物的格子置为0即可
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //1初始化dp[]数组 初始化第一行或者第一列
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        //2根据递推公式 dp[i][j]=dp[i-1][j]+dp[i][j-1]遍历二维数组求值即可
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int a[][] = new int[3][3];
        a[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(a));
    }
}

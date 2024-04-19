package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/15 15:22
 * @注释 买卖股票最佳时机I
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class LC121 {

    /**
     * 1定义一个二维数组   int [] dp=new int[][2]
     * dp[i][0] 表示第i持有这个股票
     * dp[i][1] 表示第i不持有这个股票
     * <p>
     * 2递推公式
     * <p>
     * 2.1 dp[i][0]= 前i-1天就持有了这个股票  或者在第i买入这个股票
     * dp[i][0]=Max(dp[i-1][0],-price[i])
     * 2.2 dp[i][1] 前i-1天就不持有了  或者在第i天卖出不持有了
     * dp[i][1]=Max(dp[i-1][1],dp[i-1][0] +price[i])
     * <p>
     * 3、由上面的递推公式可以得出要初始化的值是
     * dp[0][0]=-num[0]
     * dp[0][1]=0;
     * <p>
     * 4、返回dp[i-1][1]  在最后一定是不持有这个股票有更多的现金
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0-prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        int price[] = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(price));
    }

}

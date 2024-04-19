package com.study.practice.learn.dp;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/17 11:13
 * @注释给定一个整数数组prices，其中第 prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class LC309 {


    /**
     * 这个和买卖股票II相似
     * 对于每一天只有买和卖
     * <p>
     * 买：延续上一天的买的状态 || 上两天卖的状态下 在今买入【这样在初始化的时候 要初始化前两天的元素】
     * <p>
     * 卖： 延续上一天的卖的情况  ||  上一天买的状态下 在今天卖出-手续费 【每笔交易有手续费 那就按照在卖的时候有手续费】
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        /**
         * 初始化前两个元素
         */
        buy[0] = -prices[0];
        sell[0] = 0;

        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        //循环的时候 从第二个元素开始 要
        for (int i = 2; i < prices.length; i++) {
            //买：冷冻期是卖出一天后不能再买 所以这个状态是依靠sell的前两天的状态的
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            //卖：是没有任何影响的
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];

    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));

    }
}

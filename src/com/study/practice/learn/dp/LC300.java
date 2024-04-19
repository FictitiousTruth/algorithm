package com.study.practice.learn.dp;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/15 11:15
 * @注释: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class LC300 {


    /**
     * 解题思路: dp[i] 表示的含义是：已nums[i]作为结尾元素的最长序列 那么每个元素作为
     * 结尾的最长递增子序列的长度至少为1 那么dp[i] 就都初始化为1
     * <p>
     * nums = [10,  9,   2,  5,  3,  7,   101,  18]
     * j    i
     * 分别遍历数组中的每一个元素
     * 如果num[i]>num[j] 表示以num[i] 结尾的元素就是d[j]+1
     * 这个  0<=j<i  那么就是从头用每一个元素试图和i构成最长的递增序列
     * 那么就是要在这些结果中选取一个最大的
     * 递推公式：
     * <p>
     * if(num[i]>num[j]){
     * dp[i]=Max(dp[j]+1,dp[i])
     * }
     * <p>
     * 初始化dp[i]=1
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < dp.length; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 4, 4};
        System.out.println(lengthOfLIS(nums));
    }
}

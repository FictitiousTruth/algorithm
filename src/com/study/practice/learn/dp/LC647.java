package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/17 16:54
 * @注释 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class LC647 {

    public static int findLengthOfLCIS(int[] nums) {
        //dp[i] 是以数组中元素为i的连续的子串
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i]=Math.max(dp[i-1]+1,dp[i]);
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = dp[i] > max ? dp[i] : max;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,2};
        System.out.println(findLengthOfLCIS(arr));
    }
}

package com.study.practice.learn.dp;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/15 14:16
 * @注释：打家劫舍 2 这时候房间是连成环的
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class LC213 {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        //考虑第一个元素  不考虑最后一个元素
        int[] ints = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int max1 = robHelper(ints);
        //不考虑第一个元素  考虑最后一个元素
        int[] ints2 = Arrays.copyOfRange(nums, 1, nums.length );
        int max2 = robHelper(ints2);
        return max2 > max1 ? max2 : max1;
    }

    public static int robHelper(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        /**
         * 递推公式：
         *  dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
         *
         *  dp[i] 表示的含义是 偷第i个房间 偷到的金额最大值
         *
         *  在这个递推公式中 从第三个房间开始 要么偷本房间的+前面那个不相邻的元素的  和 前面那个房间的值 求最大
         *  这个房间怎么偷是和前一个和前两个房间相关的。
         *
         *  dp[0]=nums[0]
         *  dp[1]=Max(nums[0],nums[1])
         */
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }


}

package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/15 13:31
 * @注释 打家劫舍问题：
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class LC198 {

    public static int rob(int[] nums) {
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
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }
}

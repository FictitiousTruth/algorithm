package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/18 16:39
 * @注释:《最长重复子数组》 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class LC718 {

    /**
     * @param nums1
     * @param nums2
     * @return 1使用一个二维数组
     * 2如果dp[i]==dp[j]  就去查看 i的抢一个元素 和 j的前一个元素是否相等 如果相等 那么dp[i][j]=dp[i-1][j-1]+1
     */
    public static int findLength(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    //这种情况是数组越界的情况 此时就直接赋值1就可以了
                    if (i - 1 < 0 || j - 1 < 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }


                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));
    }
}

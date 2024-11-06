package com.study.practice.leetcodeTop100;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组
 * 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 《最大子数组和》 补充:子数组是一个数组中连续的一部分
 */
public class LC53 {


    /**
     * 解题思路：dp[i] 表示的含义是以 num[i]为结尾的子数组的最大连续和
     * dp[i]=Max(dp[i-1]+num[i],num[i])
     * 举例：
     * num=【-2, 1, -3, 4, -1, 2, 1, -5, 4】
     * maxArray=[-2,1,-2,4,3,5,6,1,5]
     * 以num[0] 为结尾的最大和是-2
     * num[1] 为结尾的最大和是= 如果前一个以num[i-1]为结尾的最大子数组的和 +当前自己 比自己还小 那么
     * 此时以num[1]为结尾的子数组最大连续和 还不如 不加上前一个以num[0]为结尾的子数组的最大和 加上前一个
     * 以后 ,和更小了
     * num[1]=1
     * num[2]=Max(1+(-3),-3)=-2这种情况是加上前一个后自己变得更大了 此时加上前一个会让自己变得更大。
     * 以num[2]结尾的子数组组合情况：
     * -2 1 -3  ---->这个和是-4
     * 1 -3---->这种情况是-2
     * -3---->这种情况是-3   其中这种也是一个枚举的方式,只是枚举的角度不同：dp[i]=Max(dp[i-1]+num[i],num[i])
     *
     * @param nums 数组
     * @return 最大连续子数组的和
     */
    public static int maxSubArray(int[] nums) {

        // maxValue表示以num[i]为结尾的子数组最大和组成的数组
        int[] maxArray = new int[nums.length];
        // 默认最大值是数组中的第一个
        maxArray[0] = nums[0];
        // 当前数组中最大子数组的和
        int result = nums[0];

        // 从第二个元素开始往后查找
        for (int i = 1; i < nums.length; i++) {
            // temp表示的是 以nums[i]为结尾的子数组的和
            maxArray[i] = Math.max(maxArray[i - 1] + nums[i], nums[i]);
            result = Math.max(result, maxArray[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

    }

}

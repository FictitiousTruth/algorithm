package com.study.practice.leetcodeTop100;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何子数组的乘积都 保证 是一个 32-位 整数
 * 《乘积最大子数组》
 */
public class LC152 {

    /**
     * 暴力枚举方法：列举每一个元素构成的子数组 列举所有然后求出最大值.
     * 暴力枚举当前数组的索引下列举成所有构成的子数组 然后求出这些子数组中最大值
     *
     * @param nums
     * @return
     */
    public static int maxNum1(int[] nums) {

        //默认最大值是第一个元素
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // 从0 1 2 3.....n 选出每一轮中的最大值
            int currentMax = nums[i];
            // 每一轮总的乘积
            int current = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                current = current * nums[j];
                currentMax = Math.max(current, currentMax);
            }

            // 每一轮的最大值和总的最大值进行比较
            result = Math.max(result, currentMax);
        }
        return result;
    }

    public static int maxNum2(int[] nums) {

        // 以nums[i]结尾的最小子数组乘积
        int[] min = new int[nums.length];
        // 以nums[i]结尾的最大子数组乘积
        int[] max = new int[nums.length];

        // 初始时min max都是nums[0]
        min[0] = nums[0];
        max[0] = nums[0];

        // 结果值
        int result = nums[0];

        // 从第二个开始遍历找最大值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 如果当前元素>0 那么以nums[i]结尾的子数组乘积的最大值就是 当前Max(前一个最大子数组乘积*当前元素,当前元素)
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                // 如果当前元素>0 那么以nums[i]结尾的子数组乘积的最小值就是 当前min(前一个最小子数组乘积*当前元素,当前元素)
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);

            } else {
                // 如果当前元素<0  那么再求以当前元素为结尾最大积子数组 就是Max(前一个最小*当前元素,当前元素)
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                // 如果当前元素<0  那么再求以当前元素为结尾最小积子数组 就是min(前一个最大*当前元素,当前元素)
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
                result = Math.max(result, max[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int[] arr2 = {-2, 0, -1};

        System.out.println(maxNum1(arr));
        System.out.println(maxNum2(arr));
    }

}

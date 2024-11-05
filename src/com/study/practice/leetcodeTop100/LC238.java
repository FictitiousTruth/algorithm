package com.study.practice.leetcodeTop100;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 * <p>
 * 《除自身以外数组的乘积》
 */
public class LC238 {
    /**
     * 解题思路: 除自身外数组的乘机=  当前元素左侧元素的乘积 * 当前元素右侧的乘积
     * 补充： 如果使用总数组之积 / 当前元素 =除自身外数组的乘机 那么如果数组中有0就完全失效了
     * 不能使用这种方法 况且题目中明确说明不能使用除法
     *
     * @param nums 数组
     * @return 除自身外数组乘积构成的数组
     */
    public static int[] productExceptSelf(int[] nums) {
        // 除自身外数组乘积构成的数组
        int[] result = new int[nums.length];
        // 当前元素的左侧所有元素之积
        int[] left = new int[nums.length];
        // 当前元素的右侧所有元素之积
        int[] right = new int[nums.length];

        /**
         * 填充left
         * left是从原始数组从左到右逐渐变大 所以这一步的初始化是从左到右
         * left[0]=1
         * */
        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            // 当前元素左侧所有的值的乘积=前一个元素左侧所有元素乘积*前一个元素
            left[i] = left[i - 1] * nums[i - 1];
        }
        /**
         * 填充right
         * right是从原始数组从右到左逐渐变大 所以这一步的初始化是从右到左
         * right[nums.length-1]=1;
         */
        right[nums.length - 1] = 1;

        // !!!!!!!!!这个地方是i>=0 不然的话right[0]是不会求出来的 >0 最多是到1
        for (int i = nums.length - 2; i >= 0; i--) {
            // 当前元素右侧所有的值的乘积=后一个元素的右侧所有元素乘积* 后一个元素
            right[i] = right[i + 1] * nums[i + 1];
        }

        /**
         * 分别遍历rigth[] 和left[] 那么result[i]=right[i]*left[i]
         * 也就是除自身外数组的乘机=  当前元素左侧元素的乘积 * 当前元素右侧的乘积
         *
         * */
        for (int i = 0; i < result.length; i++) {
            result[i] = right[i] * left[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

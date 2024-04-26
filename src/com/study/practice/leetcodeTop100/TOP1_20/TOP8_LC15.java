package com.study.practice.leetcodeTop100.TOP1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/22 10:31
 * @注释 《三数之和》
 * 解法：排序+双指针
 */
public class TOP8_LC15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //1 排序
        Arrays.sort(nums);
        /**
         * num[i]+num[j]+num[k]==0
         * num[i]+num[j]=-num[k] 退化为求两数之和
         *
         * 这里是可以写成i < nums.length  下面的while循环中是left<right
         * 0 1 2
         *     i =2
         *     left=3
         *     right=2
         *     并不满足left<right
         * 下面的while循环最能满足最后三个元素
         */
        for (int i = 0; i < nums.length; i++) {
            //排序完以后 如果最小的数字>0 那么 num[i]+num[j]+num[k]==0就不可能实现
            if (nums[i] > 0) return result;
            //对num[i] 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            /**
             * -5   1   1   2   3   4  4
             *      left               right
             * 从左右两侧开始缩小范围
             *  如果此时三数之和>0 让right--
             *  如果此时三数之和<0 让left++
             * 对num[j] num[k]的去重 应该是在找到一组三元组以后 进行去重
             */
            int left = i + 1, right = nums.length - 1;
            //不断从外向里面缩减
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    //找到这样的三元组了
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    /**
                     * 对num[j]去重
                     * 这里不要写成left == nums[left ++] 这样的话 执行完成以后 left的值就增加1了
                     */
                    while (left < right && nums[left] == nums[left + 1]  ) {
                        left++;
                    }
                    //对num[k]去重
                    while (left < right && nums[right] == nums[right - 1]  ) {
                        right--;
                    }
                    //当退出while循环的时候 要让left++ rigth-- 此时才指向下一组不重复的元素
                    left++;
                    right--;
                }

            }

        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1};
        System.out.println(threeSum(arr).toString());
        int i = 0;
        i++;
        System.out.println(i);
        int j=i+1;
        System.out.println(i);
    }
}

package com.study.practice.leetcodeTop100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 《多数元素》
 */
public class LC169 {

    /**
     * @param nums 数组
     * @return 超过n/2的元素
     */
    public static int majorityElement(int[] nums) {

        // 遍历所有元素 将各个元素出现的次数记录下来
        HashMap<Integer, Integer> freMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freMap.containsKey(nums[i])) {
                freMap.put(nums[i], freMap.get(nums[i]) + 1);
            } else {
                freMap.put(nums[i], 1);
            }
        }

        // 找出数量超过n/2的元素
        Iterator<Map.Entry<Integer, Integer>> iterator = freMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (value > nums.length / 2) {
                return next.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums2));

    }
}

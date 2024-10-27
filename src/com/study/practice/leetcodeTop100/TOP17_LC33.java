package com.study.practice.leetcodeTop100;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/25 13:25
 * @注释 《搜索旋转排序数组》
 * 解法： 二分搜索法
 */
public class TOP17_LC33 {


    /**
     * 原始数组是有序的 可以考虑使用二分查找法 每次拆分至少有一半是有序的
     *
     * 1、将数组一分为2 一定有一部分数组是有序的
     * 2、left<= right 数组是有序的 反之无序  middle=left+right  / 2
     * 3、如果 left~middle 这段区间有序 先判断target==nums[middle]是直接返回;
     *     否则如果target 在这个有序区间中 更新right 如果target不在这个有序区间 更新left
     *
     *   同理middle~right 重复3的判断逻辑
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            //1 [left,midlle) 这边是顺序区间 且target在顺序区间内
            if (nums[left] <= nums[middle]) {
                //taget在顺序区间内
                if (nums[left] <= target && target <= nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                //2 (middle~rigt]这个区间是顺序区间
                if (nums[middle] <= target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
       // int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = new int[]{5,1,3};
        //System.out.println(search(nums, 0));
        System.out.println(search(nums2, 0));
    }
}

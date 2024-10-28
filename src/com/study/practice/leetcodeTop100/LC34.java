package com.study.practice.leetcodeTop100;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/25 14:18
 * @注释 《在排序数组中查找元素的第一个和最后一个位》
 */
public class LC34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if ( nums.length==0 ||target < nums[0] || target > nums[nums.length - 1] ) return result;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            //找到了目标值
            if (nums[middle] == target) {
                int leftindex = middle;
                int rigthindex = middle;
                while (1 <= leftindex && nums[leftindex] == nums[leftindex - 1]) {
                    leftindex = leftindex - 1;
                }
                while (rigthindex <= nums.length - 2 && nums[rigthindex] == nums[rigthindex + 1]) {
                    rigthindex = rigthindex + 1;
                }
                result[0] = leftindex;
                result[1] = rigthindex;
                return result;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        int[] ints = searchRange(arr, 1);
        System.out.println(ints[0]+"==="+ints[1]);
    }
}

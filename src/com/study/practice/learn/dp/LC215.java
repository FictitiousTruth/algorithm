package com.study.practice.learn.dp;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/17 14:12
 * @注释: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class LC215 {
    public static int findKthLargest(int[] nums, int k) {

        return quick(nums, 0, nums.length-1, nums.length - k);

    }

    static int quick(int[] a, int left, int right, int index) {
        int p = partion(a, right, left);
        if (p == index) {
            return a[p];
        }
        if (p < index) {
            return quick(a, p + 1, right, index);
        } else {
            return quick(a, left, p - 1, index);
        }
    }


    /**
     * 分区函数
     */
    private static int partion(int[] a, int right, int left) {
        //随机选出一个下表的元素作为基准点
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        //将该基准点和最左侧元素交换 选最左侧为基准点
        swap(a, left, idx);
        //pv就是基准点
        int pv = a[left];
        //i用来找比基准点大的元素 【先找这个】
        int i = left + 1;
        //j用来找比基准点小的元素
        int j = right;
        while (i <= j) {
            //i找比基准点大的元素 并且是先找这个元素
            while (i <=j && pv > a[i]) {
                i++;
            }
            while (i <= j && pv < a[j]) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;

            }
        }
        swap(a, j, left);
        return j;
    }

    /**
     * 交换IJ两个位置的元素
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));

    }


}

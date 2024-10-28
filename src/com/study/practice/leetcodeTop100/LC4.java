package com.study.practice.leetcodeTop100;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/19 15:45
 * @注释 《寻找两个正序数组的中位数》
 */
public class LC4 {


    /**
     * 解题思路：
     * 1将两个数组合并起来 直接返回中位数
     * 原本的数组就是有序的
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0 && nums2.length!=0){
            return nums2.length%2==0 ? (nums2[nums2.length/2]+nums2[nums2.length/2-1])/2.0 : nums2[nums2.length/2]/1.0;
        }
        if (nums1.length!=0 && nums2.length==0){
            return nums1.length%2==0 ? (nums1[nums1.length/2]+nums1[nums1.length/2-1])/2.0 : nums1[nums1.length/2]/1.0;
        }
        if (nums1.length==0 && nums2.length==0){
            return 0.0;
        }

        int len = nums1.length + nums2.length;
        int[] arr = new int[len];
        int index = 0, istart = 0, jstart = 0;
        int iend = nums1.length-1;
        int jend = nums2.length-1;

        while (istart <=iend && jstart <= jend) {
            if (nums1[istart] <= nums2[jstart]) {
                arr[index] = nums1[istart];
                istart++;
            } else {
                arr[index] = nums2[jstart];
                jstart++;
            }
            index++;
        }
        if (istart >= iend) {
            //num2中的剩余元素放进arr
            System.arraycopy(nums2, jstart, arr, index, jend-jstart   + 1);
        }
        if (jstart >= jend) {
            //将num1中的元素放进arr
            System.arraycopy(nums1, istart, arr, index, iend - istart + 1);
        }
        int middleIndex = len / 2;
        return arr.length % 2 == 0 ? (arr[middleIndex] + arr[middleIndex - 1]) / 2.0 : arr[middleIndex] / 1.0;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}

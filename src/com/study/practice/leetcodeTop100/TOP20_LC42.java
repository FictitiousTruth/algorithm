package com.study.practice.leetcodeTop100;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/25 17:16
 * @注释 《接雨水》
 * 单调栈 【顶--->低】
 * 【小--->大】
 * <p>
 * 接雨水是要找到右边第一个比当前柱子大
 * 左边第一个比当前柱子大的元素 这样来求盛雨水的高度
 * 栈里面放的是数组的下标索引
 */
public class TOP20_LC42 {
    public static int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        //栈顶元素最小
        int sumare = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
               while (!stack.isEmpty() ){

               }
                stack.push(i);
            }

        }
        return sumare;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }
}

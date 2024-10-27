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



    /**
     * 解题思路：
     * 1、维护一个单调增的栈。【从栈顶到栈底是单调增】栈中元素存的是 数组的下标 后面计算雨水的面积时需要用到
     * 2、遇到比栈顶的元素小的 或者等于的 直接放进栈中
     * 3、遇到比栈顶元素大的，将栈顶元素弹出
     *  3.1如果此时栈不为空 说明遇到了一个 高 低 高  || 高  和前一个高同大  更高 （这种计算出来的面积时为0 对结果没有影响的） 这样的柱子 要进行收集面积
     *  重复步骤3 直到栈顶元素比当前元素大 或者 栈为空。之后将当前元素加入栈即可
     *
     *
     *
     *
     * */
    public static int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        //栈顶元素最小
        int sumare = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    //popValue是这三个柱子里面最矮的那个,找出另外两个高的柱子里面较矮的那个 然后长*宽 进行求面积
                    int popValue = height[stack.pop()];
                    if (!stack.isEmpty()) {
                        int peekValue = height[stack.peek()];
                        /**
                         * 求接雨水的体积 不要忘了-1 是求两个柱子之间的横向距离
                         * 这里应该是i-stack.peek() -1
                         *
                         */
                        sumare = sumare + (i - stack.peek() - 1) * (Math.min(height[i], peekValue) - popValue);
                    }

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

package com.study.practice.leetcodeTop100;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/23 17:36
 * @注释 《最长有效括号》
 * 解题思路： 借助栈
 */
public class LC32 {


    /**
     * @param s
     * @return 解题思路： （ ） ） （（））
     * 1首先向栈中放入一个 -1 这种情况是为了这种  （） 这种情况的
     * 2建立一个栈 遇到( 放入栈中  遇到 ) 弹出栈顶元素 如果弹出以后栈顶元素为空 将当前元素的下标放进去
     * 利用当前元素-栈顶元素的index 计算最大长度
     * 栈中存放的是下标索引
     */
    public static int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;
        char[] array = s.toCharArray();
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        //初始化栈中元素
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(i);
            } else {
                /**
                 * 遇到 ） 元素
                 * 弹出栈顶元素
                 * 如果当前栈顶元素为空将当前元素加入进去
                 * 计算长度
                 */
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}

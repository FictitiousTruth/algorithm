package com.study.practice.leetcodeTop100;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/23 13:08
 * @注释 《生成有效的括号》
 */
public class LC22 {

    /**
     * 有效的括号是
     * 左括号数量==右括号的数量
     * 如果出现左<右 一定是无效的
     * 只有左>=右的时候才可能是有效的括号
     */
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        backTracing(list, n, 0, 0, "");
        return list;

    }

    private static void backTracing(List<String> list, int n, int left, int right, String currentStr) {
        //找到目标值
        if (left == right && left == n) {
            list.add(currentStr.toString());
        }
        /**
         * 左括号可以添加的条件是 left<n 且 左括号>=有括号
         *
         */
        if (left < n && left >= right) {
            backTracing(list, n, left + 1, right, currentStr + "(");
        }
        /**
         * 右括号可以添加的条件是 right<n 且 左括号>有括号 【‘（’==‘）’的时候 也是不能添加的】
         *
         */
        if (right < n && left > right) {
            backTracing(list, n, left, right + 1, currentStr + ")");
        }

    }


    /**
     * 这个比方式一效率更高
     * 这里使用的是StringBuilder在尝试添加以后要进行删除
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis2(int n) {
        ArrayList<String> list = new ArrayList<>();
        backTracing2(list, n, 0, 0, new StringBuilder());
        return list;

    }

    private static void backTracing2(List<String> list, int n, int left, int right, StringBuilder currentStr) {
        //找到目标值
        if (left == right && left == n) {
            list.add(currentStr.toString());
        }
        /**
         * 左括号可以添加的条件是 left<n 且 左括号>=有括号
         *
         */
        if (left < n && left >= right) {
            backTracing2(list, n, left + 1, right, currentStr.append("("));
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
        /**
         * 右括号可以添加的条件是 right<n 且 左括号>有括号 【‘（’==‘）’的时候 也是不能添加的】
         *
         */
        if (right < n && left > right) {
            backTracing2(list, n, left, right + 1, currentStr.append(")"));
            currentStr.deleteCharAt(currentStr.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis2(3).toString());
    }
}

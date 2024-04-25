package com.study.practice.learn.backtrack.zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/25 15:12
 * @注释 《组合基础版》
 */
public class LC77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTracing(result, path, n, k, 1);
        return result;
    }

    /**
     * @param result     返回结果
     * @param path       元素每次收集时路径上的结果集
     * @param n          题目中的n
     * @param k          要求数字的个数
     * @param startIndex 每次for循环开启的位置
     */
    private static void backTracing(List<List<Integer>> result, LinkedList<Integer> path, int n, int k, int startIndex) {
        //中止条件 当收集的元素个数==k 说明找到了目标元素
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        /**
         * todo i <= n - (k - path.size()) + 1 剪枝操作
         * 对于根本凑不够 K个元素的组合 直接不用遍历了
         */
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracing(result, path, n, k, i + 1);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        System.out.println(combine(1, 1).toString());
    }
}

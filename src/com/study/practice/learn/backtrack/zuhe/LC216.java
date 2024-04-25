package com.study.practice.learn.backtrack.zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/25 16:27
 * @注释 《组合III》
 */
public class LC216 {
    public  static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        brackTracing(result, path, 1, k, n, 0);
        return result;
    }

    private static void brackTracing(List<List<Integer>> result, LinkedList<Integer> path, int startindex, int k, int n, int sum) {
        if (sum > n) {
            return;
        }
        if (sum == n && path.size() == k) {
            result.add(new ArrayList<>(path));
        }
        for (int j = startindex; j <= 9; j++) {
            path.add(j);
            sum = sum + j;
            brackTracing(result, path, j + 1, k, n, sum);
            path.removeLast();
            sum = sum - j;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(4, 1).toString());
    }

}

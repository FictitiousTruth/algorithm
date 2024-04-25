package com.study.practice.learn.backtrack.zuhe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/25 14:35
 * @注释 《组合总合》
 */
public class LC39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        bracTracing(candidates, result, path, 0, 0, target);
        return result;

    }

    private static void bracTracing(int[] candidates, List<List<Integer>> result, LinkedList<Integer> path, int sum, int startindex, int target) {
        //中止条件
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;
        for (int i = startindex; i <= candidates.length - 1; i++) {
            sum = sum + candidates[i];
            path.add(candidates[i]);
            bracTracing(candidates, result, path, sum, i, target);
            path.removeLast();
            sum = sum - candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7).toString());

    }
}

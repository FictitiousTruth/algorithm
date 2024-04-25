package com.study.practice.learn.backtrack.zuhe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/25 16:59
 * @注释 《组合总和II》
 */
public class LC40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resiult = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] visted = new boolean[candidates.length];
        Arrays.fill(visted, false);
        Arrays.sort(candidates);
        backTracing(resiult, path, candidates, target, 0, 0, visted);
        System.out.println(visted.toString());
        return resiult;
    }

    /**
     * @param resiult
     * @param path
     * @param candidates
     * @param target
     * @param starindex
     * @param visted     这个是用来表示每个元素是否访问过的 用于去重
     */

    private static void backTracing(List<List<Integer>> resiult, LinkedList<Integer> path, int[] candidates, int target, int starindex, int sum, boolean[] visted) {
        /*
         * todo 先排序  在遍历的时候 将visited=true 表示已经使用过 程序结束的时候 visdted 里面的值都是false
         *
         *
         * */
        if (sum > target) return;
        if (sum == target) {
            resiult.add(new ArrayList<>(path));
            return;
        }
        for (int i = starindex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !visted[i]) {
                continue;
            }
            sum = sum + candidates[i];
            visted[i] = true;
            path.add(candidates[i]);

            backTracing(resiult, path, candidates, target, i + 1, sum, visted);


            sum = sum - candidates[i];
            visted[i] = false;
            path.removeLast();

        }

    }

    public static void main(String[] args) {

        int[] target = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(target, 8));
    }

}

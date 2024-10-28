package com.study.practice.leetcodeTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/26 10:25
 * @注释 《全排序》
 */
public class LC46 {


    /**
    * 解题思路：
    * 从不排列中挑选出来元素 对于已经使用过的 直接跳过去
    *
    * */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        LinkedList<Integer> path = new LinkedList<>();
        boolean visited[] = new boolean[nums.length];
        Arrays.fill(visited, false);
        backTracing(result, path, visited, nums);
        return result;
    }

    private static void backTracing(List<List<Integer>> result, LinkedList<Integer> path, boolean visited[], int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            path.push(nums[i]);
            visited[i] = true;
            backTracing(result, path, visited, nums);
            visited[i] = false;
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(permute(arr).toString());
    }
}

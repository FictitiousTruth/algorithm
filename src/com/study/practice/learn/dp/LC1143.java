package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/18 16:58
 * @注释 《最长公共子序列》
 */
public class LC1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        int max = 0;
        char[] chars = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        //初始化第一行 和第一列
        for (int i = 0; i < chars2.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < chars.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < chars.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max=Math.max(dp[i][j],max);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "def2"));
    }

}

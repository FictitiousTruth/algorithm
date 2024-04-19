package com.study.practice.learn.dp;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/17 16:05
 * @注释： 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 * 如果不存在这样的子字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 * <p>
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 */
public class LC395 {

    /**
     * 1先统计每个字符串出现的次数
     * 2遍历字符串 将字符串中出现次数<k的子串切割 将切割的资产再进行处理
     *
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        //由于字符串中只有字符 所以可以使用一个字符串存储
        //让每个字符串-"a" 作为下表
        // a--> 0  b-->1  c-->2 d---->3.....
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char temp : chars) {
            arr[temp - 'a']++;
        }
        //遍历字符串进行切割
        for (int i = 0; i < s.length(); i++) {
            char temp2 = s.charAt(i);
            //如果出现了 次数<k的字符串 那么就继续往后找 看看还有没有 出现次数<k的字符一起切割

            //进入这个if表示字符串中有不符合的字符
            if (arr[temp2 - 'a'] > 0 && arr[temp2 - 'a'] < k) {
                int j = i + 1;
                //一直去找连续的不符合条件的字串
                while (j < s.length() && arr[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                //将切割的字符串在进行切割查找符合要的
                String substring = s.substring(0, i);
                String substring1 = s.substring(j);
                return Math.max(longestSubstring(substring, k), longestSubstring(substring1, k));
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababacb", 3));

    }
}

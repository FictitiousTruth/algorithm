package com.study.practice.leetcodeTop100;

import java.util.HashSet;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/18 11:12
 * @注释 《无重复字符的最长子串》
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 * 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */


public class TOP3_LC3 {


    /**
     * @param s
     * @return 解题思路：双指针+滑动窗口
     * 1定义一个左指针 一个右指针【初始均指向集合的第一个位置】 一个去重集合
     * 2让右指针不断向后移动 同时将p2指针指向的元素添加到集合中
     * 2.1如果添加成功 继续移动p2指针 更新当前的最大值
     * 2.2如果添加失败   让p1不断向右移动 同时删除集合中的元素 直到能添加成功
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        int p1 = 0;
        int p2 = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        while (p2 < s.length()) {
            char c = s.charAt(p2);
            if (set.add(c)) {
                //向集合中添加元素成功的 更新当前长度 更新最大长度 让右指针向右继续移动
                maxLength = Math.max(p2 - p1 + 1, maxLength);
                p2++;
            } else {
                //添加失败的时候 将p1指向的元素从集合中删除 并将p1指针向后移动一位 此时会进入外面的while循环仍然继续判断能不能添加成功
                set.remove(s.charAt(p1));
                p1++;
            }
        }
        return maxLength;
    }


    /**
     * 方法二 这种多维护一个currentLength长度这样
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int p1 = 0;
        int p2 = 0;
        int currentLength = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        while (p2 < s.length()) {
            char c = s.charAt(p2);
            if (set.add(c)) {
                //向集合中添加元素成功的 更新当前长度 更新最大长度 让右指针向右继续移动
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
                p2++;
            } else {
                //添加失败的时候 让p1指针不断向右移 并从集合中移除p1指针指向的元素 直到p2指针对应的元素能添加到集合中
                while (!set.add(c)) {
                    set.remove(s.charAt(p1));
                    currentLength--;
                    p1++;
                }
                //todo 这个做的时候漏掉了 在把s1放进去以后 此时要把p2指针向后移动 此外退出while循环的时候 set.add(s1)是执行成功的 currentLenth长度要加1
                p2++;
                currentLength++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}

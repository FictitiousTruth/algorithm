package com.study.practice.learn.strings;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/19 16:50
 * @注释 《KMP匹配字符串》
 * <p>
 * 最长前后缀数组：只和模式字符串相关
 * 1这个数组的索引表示：使用了模式字符串前j个字符串-1
 * 2数组的值表示 最长前后缀的长度(也就是要跳转的位置)
 */
public class KMP_LC28 {


    static int strStr(String str1, String str2) {
        char[] origin = str1.toCharArray();
        char[] pattern = str2.toCharArray();
        //lsp就是最长前后缀数组
        int[] lsp = lsp(pattern);
        /**
         * 1 匹配成功i++ j++ 知道j==模式字符串长度
         *
         * 2 匹配失败
         *   j!=0 跳过最长前后缀字符 继续匹配
         *   j==0 则i++
         */
        int i = 0;
        int j = 0;
        while (i < origin.length) {
            if (origin[i] == pattern[j]) {
                i++;
                j++;
            }
            if (j == pattern.length) {
                //找到解了 此时开始的索引就是i-模式字符串的长度
                return i - pattern.length;
            } else {
                //这种情况是一上来就匹配失败了 那么就需要让i 向前移动匹配下一个字符
                if (j == 0) {
                    i++;
                } else {
                    j = lsp[j - 1];
                }
            }
        }

        return -1;
    }

    private static int[] lsp(char[] pattern) {


        return new int[1];

    }
}



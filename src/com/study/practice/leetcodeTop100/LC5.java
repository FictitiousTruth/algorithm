package com.study.practice.leetcodeTop100;

/**
 * @version 1.0
 * @Author dlw
 * @Date 2024/4/18 20:37
 * @注释 《最长回文子串》
 * 方法一： 动态规划
 * 方法二： 中心扩展法 [跑出来的效果更好]
 */
public class LC5 {

    static int maxLen;
    static String maxStr;

    /*
     * 方法一： 动态规划
     * */
    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        /**
         * dp[i][j] 表示的含义是 i-j 字符串之间是否能形成回文子串  boolean类型默认值是false
         * j>=i 那么形成的这个二维数组中其实就是对角线上方即可
         *
         */
        boolean dp[][] = new boolean[s.length()][s.length()];
        char[] array = s.toCharArray();

        /**
         * 初始化 对角线 对角线是一定之间元素是一样的最起码能形成一个回文子串
         *
         *         for (int i = 0; i < array.length; i++) {
         *             dp[i][i] = true;
         *         }
         * 这个初始化可以放到下面的两层for循环中
         */

        /**
         * 对于一个回文串 去掉两端的字符后仍然是回文串
         * 1、array[i] == array[j]
         *          i j 同一个  j-i=0   本身就是回文串
         *          i j 相邻  j-i =1  arr[i]==arr[j] 是回文床
         *          i j 不相邻  j-i>1  dp[i][j] 是不是回文串 如果arr[i] == arr[j]  那么就取决于 dp[i+1]dp[j-1]  就是去掉两端的字符
         * 2、array[i] == array[j]
         *          dp[i][j]=false
         * 递推公式
         *                   dp[i][j]
         *   ^
         *   |
         *   |dp[i+1][j-1]
         *   |—————————————————>
         *  遍历顺序是从下向上 从左到右
         *
         *
         */
        //如果s的长度>0那么最大回文至少长度是1
        String maxStr = String.valueOf(array[0]);
        int maxLen = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) {
                    if (j - i > 1) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                    int tempLen = j - i + 1;
                    if (dp[i][j] && tempLen > maxLen) {
                        //更新最大长度和最长的字符串
                        maxLen = j - i + 1;
                        maxStr = s.substring(i, j + 1);
                    }
                } else {
                    //两端元素不相等 直接就是dp[i][j]=false 也是默认值 不用处理
                }

            }
        }
        return maxStr;
    }

    /*
     * 方法二： 中心扩展法
     * 思路：遍历数组中的每一个元素
     *    1分别以当前元素 当前元素+1 作为中心向外扩展判断是不是回文子串
     *    以当前元素 当前元素+1： 原因是可能当前的回文字符串是一个偶数 或者 技术  b a a b 比如这种 如果仅仅以其中一个元素进行判断 那么 以aa为中心的这种情况就会忽略
     *
     *    2向外扩展中两边的加进来的元素一定要是一样的
     * */
    public static String longestPalindrome2(String s) {
        if (s.length() == 1) return s;
        char[] array = s.toCharArray();
        //至少是一个元素
        maxStr = String.valueOf(array[0]);
        maxLen = 1;
        //这里要是-1 不然没有办法 i+1 以两种元素进行考虑了
        for (int i = 0; i < array.length - 1; i++) {
            palindrome(s, array, i, i);
            palindrome(s, array, i, i + 1);
        }
        return maxStr;
    }


    private static void palindrome(String s, char[] array, int left, int right) {
        while (left >= 0 && right < array.length) {
            if (array[left] == array[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        /**
         *  t b a a b k
         *    l     r
         * if (array[left] == array[right])  条件成立 执行语句 l-- r++
         *  t b a a b k
         *  l         r
         *
         * 所以退出循环的时候一定要让left ++  rigth --
         */
        left++;
        right--;
        int tempLen = right - left + 1;
        if (tempLen > maxLen) {
            maxLen = tempLen;
            maxStr = s.substring(left, right + 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aacabdkacaa"));
    }
}

package com.study.practice.leetcodeTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/22 13:56
 * @注释 《电话号码的字母组合》
 * 解法: 回溯算法
 */
public class LC17 {
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        if (digits.length() == 0) return result;
        if (digits.length() == 1) {
            return map.get(digits.charAt(0));
        }
        letterCombinationsHelper(result, map, digits, 0, new StringBuilder());
        return result;
    }

    private static void letterCombinationsHelper(ArrayList<String> result, HashMap<Character, List<String>> map, String digits, int num, StringBuilder stringBuilder) {
        if (num == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        List<String> list = map.get(digits.charAt(num));
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            letterCombinationsHelper(result, map, digits, num + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);

        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2").toString());
    }

}

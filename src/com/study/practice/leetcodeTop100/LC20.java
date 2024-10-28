package com.study.practice.leetcodeTop100;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/22 17:42
 * @注释 《有效的括号》
 */
public class LC20 {

    public static boolean isValid(String s) {
        char[] array = s.toCharArray();
        /**
         * 定义一个栈 :当遇到 (  [ { 放入到栈中
         *           遇到) ] } 弹出栈顶元素是否匹配
         *        1、如果匹配就继续
         *        2、不匹配 直接返回fase
         * 遍历完成以后 栈中不能有剩余元素 有的话就返回false
         */

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                /**
                 * todo  当遇到 ) ]  } 如果此时栈中的元素为空 那么这个字符串就是无效的括号
                 * 比如这种情况: "]"
                 */
                if (stack.isEmpty()) return false;
                Character peek = stack.peek();
                if ((c == ')' && peek == '(') || (c == ']' && peek == '[') || (c == '}' && peek == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() > 0 ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()(]"));
    }
}

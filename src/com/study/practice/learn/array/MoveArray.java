package com.study.practice.learn.array;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/18 14:40
 * @注释 《将数组整体移动K次》
 */
public class MoveArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2,
                3, 4};
        int[] ints = moveArrayHelper(arr, 3);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] moveArrayHelper(int[] arr, int k) {
        int[] result = new int[arr.length];
        int move_k = k % arr.length;
        for (int i = 0; i < arr.length; i++) {
            int index = (i + move_k) % arr.length;
            result[index] = arr[i];
        }

        return result;
    }
}

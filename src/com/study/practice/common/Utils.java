package com.study.practice.common;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Utils {
    public static void printListNode(ListNode head) {

        LinkedList<String> list = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            list.add(node.val + "");
            node = node.next;
        }
        String collect = list.stream().collect(Collectors.joining("-->", "", ""));
        System.out.println(collect);

    }
}

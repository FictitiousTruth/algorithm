package com.study.practice.leetcodeTop100;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/22 17:57
 * @注释 《合并两个有序链表》
 */
public class TOP12_LC21 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode();
        ListNode current = sentinel;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            int val1 = p1.val;
            int val2 = p2.val;
            if (val1 <= val2) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;

        }
        if (p1 == null) {
            current.next = p2;
        }
        if (p2 == null) {
            current.next = p1;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(listNode, listNode2));

    }


}

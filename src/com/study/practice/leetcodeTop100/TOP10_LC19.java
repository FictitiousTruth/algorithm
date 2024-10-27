package com.study.practice.leetcodeTop100;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/22 14:08
 * @注释 《删除链表的倒数第n个节点》
 */
public class TOP10_LC19 {


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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode s = head;
        while (s != null) {
            size++;
            s = s.next;
        }
        int target = size - n + 1;
        ListNode sentinel = new ListNode(1000);
        sentinel.next = head;
        ListNode current = head;
        ListNode pre = sentinel;
        for (int i = 1; i <= size; i++) {
            if (i == target) {
                pre.next = current.next;
                current.next = null;
                break;
            } else {
                pre = pre.next;
                current = current.next;

            }
        }
        return sentinel.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        System.out.println(removeNthFromEnd(listNode, 1));
    }
}

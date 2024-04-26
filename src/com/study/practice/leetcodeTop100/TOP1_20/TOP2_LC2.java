package com.study.practice.leetcodeTop100.TOP1_20;

/**
 * @version 1.0
 * @Author dlw
 * @Date 2024/4/19 19:52
 * @注释 《两数相加》
 */
public class TOP2_LC2 {

    static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode current = header;

        ListNode p1 = l1;
        ListNode p2 = l2;
        int t = 0;
        while (p1 != null || p2 != null) {
            int num1 = p1 == null ? 0 : p1.val;
            int num2 = p2 == null ? 0 : p2.val;
            int sum = num1 + num2 + t;
            t = sum >= 10 ? 1 : 0;
            int value = sum >= 10 ? sum - 10 : sum;
            ListNode addNode = new ListNode(value);
            //这个地方不是header.next=addNode 而是让current继续向下移动
            current.next = addNode;
            current = addNode;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (t != 0) current.next = new ListNode(t);
        return header.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(addTwoNumbers(listNode1, listNode4));


    }


}

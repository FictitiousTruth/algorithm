package com.study.practice.learn.linkedlist;

/**
 * 公用的链表节点
 */
public class ListNode {


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

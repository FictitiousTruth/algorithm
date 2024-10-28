package com.study.practice.leetcodeTop100;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * <p>
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 《相交链表》
 */
public class LC160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * 解题思路： 当两个链接的Next指针指向的下一个是相同的 则当前节点就是相交的节点
     * 遍历A链表 从第一个开始
     *     遍历B链表 从第一个开始 如果遇到AB链表的某个节点相等 此时当前节点就是所求
     *
     * @param headA 链表A的链表头部
     * @param headB 链表B的链表头部
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == headA)
            return headA;
        ListNode pA = headA;
        while (pA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (pA == pB) {
                    return pB;
                }
                pB = pB.next;
            }
            pA = pA.next;
        }
        return null;
    }
}


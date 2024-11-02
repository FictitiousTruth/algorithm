package com.study.practice.learn.linkedlist;

/**
 * 链表重排
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * 《重排链表》又叫《对折链表》
 */
public class LC143 {

    /**
     * 解题思路：
     * 1、利用快慢指针找到链表中点
     * 2、从中点的下一个节点->链表结尾 进行反转链表
     * 3、合并第1步和第2步的两个链表
     *
     * @param head
     */

    public static void reorderList(ListNode head) {
        // 链表中只有一个或者两个节点 直接返回即可
        if (head.next == null || head.next.next == null) return;

        // 慢指针
        ListNode s1 = head;
        // 快指针
        ListNode f1 = head;

        // 快指针每次走两步 慢指针每次走一步 当快指针走到链表尾部 慢指针所在位置就是链表中点<br/>
        // f1!=null 是偶数个节点的链表 当走到尾部时f1=null
        // f1.next!=null  是奇数个节点的链表 当走到尾部时f1.next=null
        while (f1 != null && f1.next != null) {
            f1 = f1.next.next;
            s1 = s1.next;
        }

        // 退出while循环时s1所在位置就是链表的中点 从该点的下一个节点开始将链表进行翻转
        ListNode newNodeHead = reverseLinkList(s1);

        // 交替从旧链表和新链表中取下一个节点进行合并
        mergeLinkList(head, newNodeHead);
    }

    /**
     * 合并两个链表
     *
     * @param head        旧链表的头部
     * @param newNodeHead 新链表的头部
     */
    private static ListNode mergeLinkList(ListNode head, ListNode newNodeHead) {
        ListNode p1 = head;
        ListNode p2 = newNodeHead;
        ListNode sentinel = new ListNode();
        ListNode newNext = sentinel;
        boolean flag = true;

        while (p1 != null && p2 != null) {
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;
            if (flag) {
                newNext.next = p1;
                p1.next = null;

                newNext = p1;

                p1 = p1Next;
                flag = false;
            } else {

                newNext.next = p2;
                p2.next = null;

                newNext = p2;

                p2 = p2Next;
                flag = true;

            }

        }

        if (p1 == null && p2 != null) {
            newNext.next = p2;
        } else if (p1 != null && p2 == null) {
            newNext.next = p1;
        } else {
            newNext.next = null;
        }
        head = sentinel.next;
        return head;
    }

    /**
     * 翻转链表
     *
     * @param s1 头节点
     * @return 反转后链表的新头节点
     */
    private static ListNode reverseLinkList(ListNode s1) {
        ListNode cur = s1.next;
        // 从s1节点开始往后进行翻转 先让s1的节点指向空
        s1.next = null;

        // 新链表的第一个节点
        ListNode newListFirstNode = null;

        while (cur != null) {
            ListNode reverseNextNode = cur.next;
            cur.next = newListFirstNode;
            newListFirstNode = cur;
            cur = reverseNextNode;
        }

        return newListFirstNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

}

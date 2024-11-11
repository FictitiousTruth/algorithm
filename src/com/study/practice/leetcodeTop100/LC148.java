package com.study.practice.leetcodeTop100;

import com.study.practice.common.ListNode;
import com.study.practice.common.Utils;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * 《链表排序》
 */
public class LC148 {


    /**
     * @param head
     * @return
     */
    public static ListNode sortListPlus(ListNode head) {
        // 特殊值判定 链表为空 或者 链表只有一个节点
        if (head == null || head.next == null) return head;
        return pXList(head, null);

    }


    private static ListNode pXList(ListNode head, ListNode tail) {
        /**
         * 当拆分的节点<=2 就不再拆分
         */
        if (head == null || head.next == null) {
            return head;
        }
        // 拆分后还剩两个节点
        if (head.next == tail) {
            if (head.val > tail.val) {
                tail.next = head;
                head.next = null;
                return tail;
            } else {
                return head;
            }
        }

        // 1利用快慢指针找到链表终点
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

        }
        // 拆分之后直接将链表断开
        ListNode mid = slow;
        ListNode next = mid.next;
        mid.next = null;
        // 2将链表进行拆分
        ListNode node1 = pXList(head, mid);
        // 3将拆分后的链表进行 合并(这里采用合并两个有序链表)
        ListNode node2 = pXList(next, tail);
        return mergeListNode(node1, node2);
    }

    /**
     * 合并两个有序链表
     *
     * @param head1 链表1头节点
     * @param head2 链表2头节点
     * @return 合并链表1 链表2后新的头节点
     */
    private static ListNode mergeListNode(ListNode head1, ListNode head2) {
        ListNode sentinel = new ListNode();
        ListNode p = sentinel;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                ListNode tempNode = head1.next;
                head1.next = null;
                p.next = head1;
                p = p.next;
                head1 = tempNode;
            } else {
                ListNode tempNode = head2.next;
                head2.next = null;
                p.next = head2;
                head2 = tempNode;
                p = p.next;
            }
        }
        /**
         * while循环结束 有且只有一个链表遍历完了 不存在两个链表都=null的情况
         */
        if (head1 == null) {
            p.next = head2;
        }
        if (head2 == null) {
            p.next = head1;
        }
        return sentinel.next;
    }


    /**
     * 执行超时
     *
     * @param head
     * @return
     */
    @Deprecated
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p1 = head;
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);

        while (p1 != null) {
            ListNode cur = sentinel;
            ListNode curNext = sentinel.next;
            while (cur != null && curNext != null && p1.val > curNext.val) {
                cur = cur.next;
                curNext = cur.next;
            }
            cur.next = p1;
            ListNode tempNode = p1.next;
            p1.next = curNext;
            p1 = tempNode;

        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode test2 = new ListNode(-1, new ListNode(2, new ListNode(2, new ListNode(4, new ListNode(5)))));
        ListNode listNode = sortListPlus(test2);
        Utils.printListNode(listNode);


    }
}

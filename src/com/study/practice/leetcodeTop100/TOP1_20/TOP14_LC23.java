package com.study.practice.leetcodeTop100.TOP1_20;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/23 14:06
 * @注释 《合并K个升序链表》
 */
public class TOP14_LC23 {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode listNode = mergeKListsHelper(lists, 0, lists.length - 1);
        return listNode;
    }

    /**
     * todo  这个mergeKListsHelper方法没有写出来
     */
    public static ListNode mergeKListsHelper(ListNode[] lists, int leftindex, int rightindex) {
        if (leftindex == rightindex) return lists[leftindex];
        //middle是中心索引坐标
        int middle = (leftindex + rightindex) / 2;

        ListNode listNode = mergeKListsHelper(lists, leftindex, middle);
        ListNode listNode2 = mergeKListsHelper(lists, middle + 1, rightindex);
        ListNode listNode1 = mergeTwoLists(listNode, listNode2);
        return listNode1;
    }


    /**
     * 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
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
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        ListNode[] arr = new ListNode[]{listNode, listNode2};
//        ListNode listNode1 = mergeKLists(arr);
//        System.out.println(listNode1);

        System.out.println(1 >>> 2);
        System.out.println(1 / 2);

    }

}

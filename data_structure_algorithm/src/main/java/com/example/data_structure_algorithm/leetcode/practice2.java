package com.example.data_structure_algorithm.leetcode;

import com.example.data_structure_algorithm.leetcode.common.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @Author: sidao.zhu
 * @Date: 2021/12/7
 */
public class practice2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pe = 0;
        ListNode newHead = new ListNode();
        ListNode tmp = newHead;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int val = val1 + val2 + pe;
            if (val >= 10) {
                val = val % 10;
                pe = 1;
            } else {
                pe = 0;
            }
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (pe == 1) {
            tmp.next = new ListNode(1);
        }
        return newHead.next;
    }

    public static void main(String[] args) {

        int[] a = {9};
        ListNode head1 = new ListNode(a[0]);
        ListNode tmp = head1;
        for (int j = 1; j < a.length; j++) {
            ListNode no = new ListNode(a[j]);
            tmp.next = no;
            tmp = no;
        }

        int[] b = {1, 9, 9, 9, 9, 9, 9, 9};
        ListNode head2 = new ListNode(b[0]);
        tmp = head2;
        for (int j = 1; j < b.length; j++) {
            ListNode no = new ListNode(b[j]);
            tmp.next = no;
            tmp = no;
        }

        ListNode listNode = addTwoNumbers(head1, head2);
        for (; listNode != null; listNode = listNode.next) {
            System.out.print(listNode.val);
        }
    }
}
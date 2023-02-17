package com.example.data_structure_algorithm.leetcode;

import com.example.data_structure_algorithm.leetcode.common.ListNode;

import java.util.List;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/8
 */
public class Practice21 {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8};
        ListNode head1 = new ListNode(a[0]);
        ListNode tmp = head1;
        for (int j = 1; j < a.length; j++) {
            ListNode no = new ListNode(a[j]);
            tmp.next = no;
            tmp = no;
        }

        int[] b = {1, 3, 5, 6, 7};
        ListNode head2 = new ListNode(b[0]);
        tmp = head2;
        for (int j = 1; j < b.length; j++) {
            ListNode no = new ListNode(b[j]);
            tmp.next = no;
            tmp = no;
        }

        ListNode listNode = removeNthFromEnd2(head1, head2);
        for (; listNode != null; listNode = listNode.next) {
            System.out.print(listNode.val);
        }

    }


    public static ListNode removeNthFromEnd2(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                listNode.next = list2;
                list2 = list2.next;
            } else {
                listNode.next = list1;
                list1 = list1.next;
            }
            listNode = listNode.next;
        }
        listNode.next = (list1 == null ? list2 : list1);
        return head.next;
    }
}

package com.example.data_structure_algorithm.leetcode;

import com.example.data_structure_algorithm.leetcode.common.ListNode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/8
 */
public class Practice141 {

    public static void main(String[] args) {

        int[] b = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        ListNode head2 = new ListNode(b[0]);
        ListNode tmp = head2;
        for (int j = 1; j < b.length; j++) {
            ListNode no = new ListNode(b[j]);
            tmp.next = no;
            tmp = no;
        }

    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null) {
            if (quick.next != null && quick.next.next != null) {
                quick = quick.next.next;
                slow = slow.next;
            } else {
                return false;
            }
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}

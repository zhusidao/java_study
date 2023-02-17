package com.example.data_structure_algorithm.leetcode;

import com.example.data_structure_algorithm.leetcode.common.ListNode;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/8
 */
public class Practice19 {
    public static void main(String[] args) {
        int[] b = {1,2,3,4,5};
        ListNode headNode = new ListNode(b[0]);
        ListNode current = headNode;
        for (int j = 1; j < b.length; j++) {
            ListNode nextNode = new ListNode(b[j]);
            current.next = nextNode;
            current = nextNode;
        }

        ListNode listNode = removeNthFromEnd2(headNode, 2);
        for (; listNode != null; listNode = listNode.next) {
            System.out.print(listNode.val);
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode();
        first.next = head;
        ListNode quick = first;
        int len = 0;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            len++;
        }
        if (quick.next != null) {
            len = (len + 1) * 2;
        } else {
            len = len * 2 + 1;
        }
        len = len - n;
        quick = first;
        for (; quick.next != null; quick = quick.next) {
            if (len == 1) {
                quick.next = quick.next.next;
                break;
            }
            len--;
        }
        first = first.next;
        return first;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode firstHead = new ListNode();
        firstHead.next = head;
        ListNode forward = firstHead;
        ListNode back = firstHead;
        while (n > 0) {
            forward = forward.next;
            n--;
        }
        while (forward.next != null) {
            forward = forward.next;
            back = back.next;
        }
        back.next = back.next.next;
        return firstHead.next;
    }
}

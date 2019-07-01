package com.rick.easy;

/**
 * 反转链表
 *
 * @author : Rick Ma at 2019/6/27 18:28
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(head1);


        iterator(head1);
        System.out.println(head1);
        printList(head1);
    }

//    public static ListNode reverseList(ListNode head) {
//        return
//    }

    private static void iterator(ListNode head) {
        ListNode next = head.next;
        head.next=null;
        if (next == null) {
            return;
        }
        iterator(next);
        next.next = head;
    }

    private static void printList(ListNode head) {
        System.out.print(head.val + "->");
        if (head.next != null) {
            printList(head.next);
        }else {
            System.out.println("NULL");
        }
    }
}

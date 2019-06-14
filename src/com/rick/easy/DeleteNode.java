package com.rick.easy;

/**
 * 237.删除链表中的节点
 *
 * @author : Rick Ma at 2019/6/12 15:33
 */
public class DeleteNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(9);


        a.next = b;
        b.next = c;
        c.next = d;

    }


    public void deleteNode(ListNode node) {
        ListNode nextNode=node.next;
        node.val=nextNode.val;
        node.next=nextNode.next;
    }
}

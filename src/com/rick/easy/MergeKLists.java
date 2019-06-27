package com.rick.easy;

/**
 * Description
 *
 * @author : Rick Ma at 2019/6/21 15:32
 */
public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result;


        for (ListNode list : lists) {
            result = new ListNode(list.val);
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        int[]  list=new int[]{2,5,7,11,23,6,8,4,9};


    }

}

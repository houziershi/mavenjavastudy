package com.leetcode;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode pointOne = head;
        ListNode pointTwo = head.next;
        while (pointTwo != null && pointOne != pointTwo) {
            pointOne = pointOne.next;
            if (pointTwo.next != null) {
                pointTwo = pointTwo.next.next;
            } else {
                pointTwo = null;
                break;
            }
        }

        if (pointTwo != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);

        root.next = node2;
        node2.next = node3;

        boolean hasCycle = LinkedListCycle.hasCycle(root);
        System.out.println("hgk...."+hasCycle);
    }

}

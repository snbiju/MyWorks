package com.app.codes.amz;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head)); // Output: true
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a single-node list is a palindrome
        }

        ListNode middle = findMiddle(head);
        ListNode reversedSecondHalf = reverseList(middle.next);

        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

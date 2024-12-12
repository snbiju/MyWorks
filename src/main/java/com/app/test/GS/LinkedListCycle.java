package com.app.test.GS;

/*

To determine whether a linked list is cyclic or not, you can use Floyd's Cycle Detection Algorithm, also known as the
 "tortoise and hare" algorithm. The idea is to have two pointers, one moving at a slower pace (tortoise) and the
 other at a faster pace (hare).
If the linked list contains a cycle, these two pointers will eventually meet.

The time complexity of Floyd's Cycle Detection Algorithm for detecting a cycle in a linked list is O(n),
where n is the number of nodes in the linked list. This is because both pointers (tortoise and hare) traverse the linked list,
 and in the worst case, they meet after completing one full cycle of the linked list.

The space complexity is O(1) since the algorithm only uses a constant amount of extra space regardless of the size of the input
 linked list.
 The space used is for the two pointers (tortoise and hare) and does not depend on the number of nodes in the linked list.

In summary:

Time Complexity: O(n)
Space Complexity: O(1)\
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            // If tortoise and hare meet, it indicates a cycle
            if (tortoise == hare) {
                return true;
            }
        }

        // No cycle found
        return false;
    }


    private boolean findLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == fast){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Example usage
        ListNode head = new ListNode(1); //3
        head.next = new ListNode(2); //2
        head.next.next = new ListNode(3);//0
        head.next.next.next = new ListNode(4);//-4
        // Creating a cycle
       // head.next.next.next.next = head.next;

        System.out.println(solution.hasCycle(head)); // Output: true
    }
}

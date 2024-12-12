package com.app.codes.GS;
/*

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
height-balanced
binary search tree.

Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []


Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-105 <= Node.val <= 105

The time complexity of the sortedListToBST algorithm is O(n), where n is the number of nodes in the linked list.
This is because each node in the linked list is visited exactly once, and for each node, a constant amount of work is done.

The space complexity is O(log n), where n is the number of nodes in the linked list. This space complexity is due to the
recursive call stack during the construction of the binary search tree. In the worst case, the recursion depth will be log n,
 corresponding to a balanced binary search tree.

Note: The space complexity analysis assumes that the input linked list can be modified. If modifying the input is not allowed,
and you need to create a separate array to store the values, the space complexity would be O(n).

 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode mid = findMiddle(head);
        TreeNode root = new TreeNode(mid.val);

        if (head == mid) {
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
}

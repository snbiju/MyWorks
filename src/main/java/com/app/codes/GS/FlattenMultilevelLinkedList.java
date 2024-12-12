package com.app.codes.GS;
/*
 You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

Example 1
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation: The multilevel linked list in the input is shown.

Example 2

Input: head = [1,2,null,3]
Output: [1,3,2]
Explanation: The multilevel linked list in the input is shown.

Example 3:

Input: head = []
Output: []
Explanation: There could be empty list in the input.


Constraints:

The number of Nodes will not exceed 1000.
1 <= Node.val <= 105


How the multilevel linked list is represented in test cases:

We use the multilevel linked list from Example 1 above:

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
The serialization of each level is as follows:

[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]
To serialize all levels together, we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:

[1,    2,    3, 4, 5, 6, null]
             |
[null, null, 7,    8, 9, 10, null]
                   |
[            null, 11, 12, null]
Merging the serialization of each level and removing trailing nulls we obtain:

[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

Time Complexity:

The method traverses each node of the doubly linked list exactly once.
Within the loop, when a child list is encountered, a recursive call is made to flatten for that child list.
Therefore, the time complexity is O(N), where N is the total number of nodes in the linked list.
Space Complexity:

The space complexity is determined by the recursion stack during the recursive calls.
In the worst case, if the linked list has a deep hierarchy of child lists, the maximum depth of recursion would be the maximum depth of the hierarchy.
Therefore, the space complexity is O(D), where D is the maximum depth of the hierarchy of child lists.
In the worst case, D could be equal to the total number of nodes N (if every node has a child list).
In practice, D is likely to be smaller, depending on the structure of the multilevel linked list.
Overall, the time complexity is O(N), and the space complexity is O(D).
 */
public class FlattenMultilevelLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;

        while (current != null) {
            if (current.down != null) {
                Node next = current.next;
                Node child = flatten(current.down);

                current.next = child;
                child.prev = current;
                current.down = null;

                while (current.next != null) {
                    current = current.next;
                }

                current.next = next;

                if (next != null) {
                    next.prev = current;
                }
            }

            current = current.next;
        }

        return head;
    }
}

 

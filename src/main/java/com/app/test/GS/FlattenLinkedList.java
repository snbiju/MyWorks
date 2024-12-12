package com.app.test.GS;
/*

It seems like there might be a typo in your question, and you intended to ask about "flattening a linked list."
Flattening a linked list typically refers to a process where a linked list with multiple levels or layers is converted into a
single-level linked list.

Let me provide you with an explanation and an example:

Flattening a Linked List:
Consider a linked list where each node has two pointers:

next points to the next node in the same level.
down points to the node in the next level.
Flattening this linked list involves rearranging it into a single-level linked list.

Example:
Suppose you have the following linked list:

1 -> 2 -> 3 -> 4
        |
        5 -> 6
        |
        7 -> 8 -> 9

The flattened linked list would be:

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9

Time Complexity:

The time complexity of the given code is mainly determined by the recursion in the flattenLinkedList and merge methods.

flattenLinkedList Method:

The recursion in flattenLinkedList involves traversing the linked list and calling merge for each level.
The time complexity is O(N), where N is the total number of nodes in the linked list.
merge Method:

The merge method performs a merge operation on two sorted linked lists recursively.
The time complexity is O(A + B), where A and B are the sizes of the two linked lists being merged.
Overall Time Complexity:

Combining the time complexity of flattenLinkedList and merge, the overall time complexity is O(N * log(M)),
 where M is the average size of the sub-lists at each level.
Space Complexity:

The space complexity of the code is determined by the recursive calls and the space required for the call stack.

Call Stack:

The recursion in both flattenLinkedList and merge contributes to the call stack space.
The maximum depth of the call stack is the maximum depth of the recursive calls, which is the number of levels in the linked list.
The space complexity due to the call stack is O(N).
Overall Space Complexity:

In addition to the call stack space, the overall space complexity is O(1) since the code modifies the existing linked list in place without using additional data structures.
In summary:

Time Complexity: O(N * log(M))
Space Complexity: O(N)

 */
class Node {
    int data;
    Node next;
    Node prev;
    Node down;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.down = null;
        Node prev=null;
    }
}



public class FlattenLinkedList {

    public static Node flattenLinkedList(Node root) {
        if (root == null || root.next == null)
            return root;
        // Recursively flatten the next level
        root.next = flattenLinkedList(root.next);
        // Flatten the current level
        root = merge(root, root.next);
        return root;
    }
    private static Node merge(Node a, Node b) {
        if (a == null){
            return b;}
        if (b == null){
            return a;}

        Node result;

        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        return result;
    }
/*public static Node flattenLinkedList(Node root) {
        if (root == null || root.next == null)
            return root;

        // Recursively flatten the next level
        root.next = flattenLinkedList(root.next);
        System.out.println("Root Next :"+root.next.data);
        // Flatten the current level
        root = merge(root, root.next);
        System.out.println("Root :"+root.data);
        return root;
    }*/
  /*  private static Node merge(Node a, Node b) {
        if (a == null){
            System.out.println("if a==null:"+b.data);
            return b;}
        if (b == null){
            System.out.println("if b==null:"+a.data);
            return a;}

        Node result;

        if (a.data < b.data) {
            result = a;
            System.out.println("a.data < b.data  :"+result.data);
            result.down = merge(a.down, b);
        } else {
            result = b;
            System.out.println("else part a.data < b.data  :"+result.data);
            result.down = merge(a, b.down);
        }

        return result;
    }*/

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.down = new Node(5);
        head.next.down.down = new Node(8);
     //   head.next.down.down.down = new Node(9);
      //  head.next.down.down.down.down = new Node(10);
     //   head.next.down.down.down.down.down = new Node(11);

        head.next.next = new Node(3);
        head.next.next.down = new Node(6);
        head.next.next.down.down = new Node(9);

        head.next.next.next = new Node(4);
        head.next.next.next.down = new Node(7);

        Node flattened = flattenLinkedList(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();

        while (flattened != null) {
            System.out.print(flattened.data + " ");
            flattened = flattened.down;
        }
    }
}


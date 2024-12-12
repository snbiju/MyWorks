package com.app.codes.ubs;

/*

A binary number is represented as a series of 0s and 1's. In this challenge, the series will be in the form of a singly-linked list.
Each node instance, a LinkedListNode, has a value, data, and a pointer to the next node, next Given reference to the haead of a singly-linked list,
convert the binary number represented to a decimal number.

Example

binary -> 0->1->0->0->1->1->null

Functional description
Complete the function getNumber in th editor

getNumber has the following parameter in below editor
binary: reference to the head of a singly-linked list of binary digit.

return:
int: a (long integer) [10] representation of a binary number

*/

public class BinaryNumberLinkedList {

    public static int getNumber(LinkedListNode binary) {
        int decimal = 0;
        while (binary != null) {
            decimal = decimal * 2 + binary.data;
            binary = binary.next;
        }
        return decimal;
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static void printList(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.next = new LinkedListNode(1);
        head.next.next = new LinkedListNode(0);
        head.next.next.next = new LinkedListNode(0);
        head.next.next.next.next = new LinkedListNode(1);
        head.next.next.next.next.next = new LinkedListNode(1);

        System.out.println("Binary: ");
        printList(head);

        int decimal = getNumber(head);
        System.out.println("\nDecimal representation: " + decimal);
    }
}

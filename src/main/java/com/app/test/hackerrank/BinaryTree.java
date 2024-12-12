package com.app.test.hackerrank;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void buildTree(int[] arr) {
        if (arr.length == 0)
            return;

        root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (i < arr.length && arr[i] != -1) {
                tempNode.left = new Node(arr[i]);
                queue.add(tempNode.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                tempNode.right = new Node(arr[i]);
                queue.add(tempNode.right);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] input = {1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9};
        tree.buildTree(input);

        System.out.println("Preorder traversal of binary tree is: ");
        tree.preOrder(tree.root);
    }
}


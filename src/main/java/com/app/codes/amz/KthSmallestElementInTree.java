package com.app.codes.amz;

/*

Problem Description



Given a binary search tree, write a function to find the kth the smallest element in the tree.
NOTE: You may assume 1 <= k <= Total number of nodes in BST


Input Format
The first argument is the root node of the binary tree.
The second argument B is an integer equal to the value of k.


Output Format
Return the value of the kth the smallest node.


Example Input
  2
 / \
1   3


and k = 2



Example Output
2


Example Explanation
As 2 is the second-smallest element in the tree.


The time complexity of the provided code is O(N), where N is the number of nodes in the binary tree.
This is because, in the worst case, the code may visit all nodes of the binary tree during the in-order traversal.

The space complexity is O(H), where H is the height of the binary tree.
This is because the space required for the recursive call stack is proportional to the height of the tree.
In the worst case, when the tree is skewed (height is N), the space complexity is O(N).
In a balanced tree, the height is approximately log(N), and the space complexity is O(log(N)).

 */

import java.util.HashMap;
import java.util.Map;

public class KthSmallestElementInTree {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inOrderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        KthSmallestElementInTree solution = new KthSmallestElementInTree();
        Map<String,String> smap= new HashMap<>();
      //  TreeNode root = new TreeNode(3);
      //  root.left = new TreeNode(1);
       // root.right = new TreeNode(4);
       // root.left.right = new TreeNode(2);


        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.left.right= new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.right.right = new TreeNode(9);
        root1.right.left = new TreeNode(7);

        int k = 2;
     //   int kthSmallest = solution.kthSmallest(root, k);
     //   System.out.println("Kth Smallest Element: " + kthSmallest); // Output: 2
        System.out.println(solution.kthSmallest(root1,2));
    }

}

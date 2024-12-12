package com.app.codes.GS;
/*
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

Exaple: 1

Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Example 2
Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0


Constraints:

The number of nodes in the tree is in the range [1, 5 * 104].
1 <= Node.val <= 100

 */
public class LongestZigZag {

    private static int maxZigZag = 0;

    public static int maxLength=0;
    public static void zigZagPath(TreeNode root,String dir,int currLength){
        if(root==null) return;
        maxLength=Math.max(maxLength,currLength);
        if(dir=="R"){
            zigZagPath(root.left,"L",currLength+1);
            zigZagPath(root.right,"R",1);
        }
        else{
            zigZagPath(root.right,"R",currLength+1);
            zigZagPath(root.left,"L",1);
        }
    }
    public static int longestZigZag(TreeNode root) {
        zigZagPath(root,"L",0);
        zigZagPath(root,"R",0);
        return maxLength;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(1);
        root1.right.left.left = new TreeNode(1);
        root1.right.left.left.right = new TreeNode(1);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.left.right= new TreeNode(1);


        // Call the function and print the result
        int result = longestZigZag(root);
        System.out.println("Longest ZigZag path length: " + result);
    }
}
class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
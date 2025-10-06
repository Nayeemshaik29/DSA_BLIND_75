/*
 * Problem: Balanced Binary Tree (LeetCode #110)
 *
 * Description:
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is defined as:
 * A binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Approach:
 * - Use post-order DFS to compute the height of subtrees.
 * - If at any point the height difference between left and right is > 1, return -1 (unbalanced).
 * - Otherwise, return the actual height.
 * - The main function checks if the result is -1 to determine if the tree is balanced.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
 *
 * Author: [Your Name]
 * Date: [Date]
 */

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    /**
     * Checks if a binary tree is height-balanced.
     *
     * @param root The root node of the binary tree.
     * @return true if the tree is balanced, false otherwise.
     */
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    /**
     * Helper method that performs post-order DFS and returns the height of the tree.
     * Returns -1 immediately if an unbalanced subtree is found.
     */
    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1; // Left subtree is unbalanced

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1; // Right subtree is unbalanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node is unbalanced

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Main method for testing the isBalanced method.
     */
    public static void main(String[] args) {
        // Sample balanced binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1,
                            new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                            new TreeNode(3));

        Solution sol = new Solution();
        boolean result = sol.isBalanced(root);

        // Print the result
        System.out.println("Is the tree balanced? " + result); // Expected: true
    }
}

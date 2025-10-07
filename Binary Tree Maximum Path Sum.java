/*
 * Problem: Binary Tree Maximum Path Sum (LeetCode #124)
 *
 * Description:
 * Given a binary tree, find the path which has the maximum sum of node values.
 * A path can start and end at any node in the tree.
 *
 * Approach:
 * - Use post-order DFS traversal.
 * - For each node, calculate the maximum gain from left and right subtrees.
 * - Ignore negative path sums by taking max(0, subtree sum).
 * - The path passing through a node = node.val + leftGain + rightGain.
 * - Maintain a global variable to track the maximum path sum found so far.
 * - Return node.val + max(leftGain, rightGain) to propagate the max single path upward.
 *
 * Time Complexity: O(n), where n is the number of nodes.
 * Space Complexity: O(h), where h is the height of the tree (recursion stack).
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
    int maxi = Integer.MIN_VALUE;

    /**
     * Finds the maximum path sum in a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The maximum path sum.
     */
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }

    /**
     * Recursive helper function that computes the maximum gain from each node.
     * Updates the global maximum path sum when a higher sum is found.
     */
    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        int currentPath = root.val + left + right;
        maxi = Math.max(maxi, currentPath);

        return root.val + Math.max(left, right);
    }

    /**
     * Main method for testing the maxPathSum method.
     */
    public static void main(String[] args) {
        // Example tree:
        //       -10
        //       /  \
        //      9   20
        //         /  \
        //        15   7
        //
        // Maximum Path Sum = 42 (15 + 20 + 7)

        TreeNode root = new TreeNode(-10,
                            new TreeNode(9),
                            new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)));

        Solution sol = new Solution();
        int result = sol.maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result); // Expected: 42
    }
}

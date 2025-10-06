/*
 * Problem: Diameter of Binary Tree (LeetCode #543)
 *
 * Description:
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes.
 * This path may or may not pass through the root.
 *
 * Approach:
 * - Perform post-order DFS to compute the height of left and right subtrees.
 * - For each node, compute the path length as left height + right height.
 * - Update a global maximum diameter if this path is longer.
 * - Return height = 1 + max(left, right) to the parent node.
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
     * Computes the diameter of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return The length of the longest path between any two nodes.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[1]; // Array used to store max diameter found so far
        height(root, dia);
        return dia[0];
    }

    /**
     * Helper method to compute height of tree and update diameter.
     *
     * @param node Current node in the traversal.
     * @param dia Array storing the maximum diameter (passed by reference).
     * @return Height of current subtree.
     */
    private int height(TreeNode node, int[] dia) {
        if (node == null) return 0;

        int lh = height(node.left, dia);   // Height of left subtree
        int rh = height(node.right, dia);  // Height of right subtree

        dia[0] = Math.max(dia[0], lh + rh); // Update diameter

        return 1 + Math.max(lh, rh); // Return current node's height
    }

    /**
     * Main method for testing the diameterOfBinaryTree method.
     */
    public static void main(String[] args) {
        // Sample tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        //
        // Expected diameter: 3 (Path: 4 -> 2 -> 5 or 4 -> 2 -> 1 -> 3)

        TreeNode root = new TreeNode(1,
                            new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                            new TreeNode(3));

        Solution sol = new Solution();
        int result = sol.diameterOfBinaryTree(root);

        // Print the result
        System.out.println("Diameter of Binary Tree: " + result); // Expected: 3
    }
}

/*
 * Problem: Binary Tree Zigzag Level Order Traversal (LeetCode #103)
 *
 * Description:
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 * Approach:
 * - Use a BFS traversal (level order) with a queue.
 * - Keep a boolean flag to determine the direction of traversal at each level.
 * - Reverse the level list if the current level is right-to-left.
 * - Toggle the direction flag after each level.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(n), for the result list and queue.
 *
 * Author: Shaik Nayeem Basha
 * Date: 7/10/2025
 */

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    /**
     * Returns the zigzag level order traversal of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of lists of integers representing the zigzag level order traversal.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (!leftToRight) Collections.reverse(level);
            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }

    /**
     * Main method for testing the zigzagLevelOrder method.
     */
    public static void main(String[] args) {
        // Sample binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6
        //
        // Zigzag Level Order: [[1], [3, 2], [4, 5, 6]]

        TreeNode root = new TreeNode(1,
                            new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                            new TreeNode(3,
                                null,
                                new TreeNode(6)));

        Solution sol = new Solution();
        List<List<Integer>> result = sol.zigzagLevelOrder(root);

        // Print the result
        System.out.println("Zigzag Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}

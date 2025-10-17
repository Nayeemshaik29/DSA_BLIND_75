/*
 * Problem: Boundary Traversal of Binary Tree
 *
 * Description:
 * Given a binary tree, perform the boundary traversal of the tree in anti-clockwise direction starting from the root.
 * The boundary includes:
 * 1. Left boundary (excluding leaves)
 * 2. All leaf nodes
 * 3. Right boundary (excluding leaves), traversed in reverse.
 *
 * Example:
 * Input Tree:
 *          1
 *        /   \
 *       2     3
 *      / \   / \
 *     4   5 6   7
 *
 * Output: [1, 2, 4, 5, 6, 7, 3]
 *
 * Approach:
 * - If root is not a leaf, add it to the result.
 * - Add all nodes on the left boundary excluding leaf nodes.
 * - Add all leaf nodes (both left and right subtrees).
 * - Add all nodes on the right boundary excluding leaf nodes in reverse order.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (due to recursion for leaves).
 *
 * Author: [Your Name]
 * Date: [Date]
 */

import java.util.*;

// Definition for a binary tree node.
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Solution {

    /**
     * Performs the boundary traversal of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list containing the boundary traversal in anti-clockwise order.
     */
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        // Add root if it's not a leaf
        if (!isLeaf(root)) ans.add(root.data);

        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }

    /**
     * Helper method to check if a node is a leaf node.
     */
    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    /**
     * Adds the left boundary of the tree (excluding leaf nodes).
     */
    private void addLeftBoundary(Node root, List<Integer> res) {
        Node cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    /**
     * Adds all leaf nodes of the tree.
     */
    private void addLeaves(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    /**
     * Adds the right boundary of the tree (excluding leaf nodes) in reverse order.
     */
    private void addRightBoundary(Node root, List<Integer> res) {
        Node cur = root.right;
        List<Integer> temp = new ArrayList<>();
        while (cur != null) {
            if (!isLeaf(cur)) temp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    /**
     * Main method to test the boundary traversal.
     */
    public static void main(String[] args) {
        // Constructing the tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Solution sol = new Solution();
        ArrayList<Integer> result = sol.boundaryTraversal(root);

        System.out.println("Boundary Traversal: " + result);
        // Expected Output: [1, 2, 4, 5, 6, 7, 3]
    }
}

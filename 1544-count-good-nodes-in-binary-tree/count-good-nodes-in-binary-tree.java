/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int good = 0;
        if (node.val >= maxSoFar) {
            good = 1; // this node is good
            maxSoFar = node.val; // update max on this path
        }

        good += dfs(node.left, maxSoFar);
        good += dfs(node.right, maxSoFar);

        return good;
    }
}
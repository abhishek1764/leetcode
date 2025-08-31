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
    int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, 1, true);   // true = came from left
        dfs(root.right, 1, false); // false = came from right
        return maxLen;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;

        maxLen = Math.max(maxLen, length);

        if (isLeft) {
            // last move was left, so next must be right
            dfs(node.right, length + 1, false);
            dfs(node.left, 1, true);  // restart path if continue left
        } else {
            // last move was right, so next must be left
            dfs(node.left, length + 1, true);
            dfs(node.right, 1, false); // restart path if continue right
        }
    }
}
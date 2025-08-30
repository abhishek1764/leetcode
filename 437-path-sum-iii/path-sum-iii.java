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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1); // Base case: one way to reach sum = 0
        return dfs(root, 0L, targetSum, prefix);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefix) {
        if (node == null) return 0;

        currSum += node.val;
        int count = prefix.getOrDefault(currSum - target, 0);

        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, target, prefix);
        count += dfs(node.right, currSum, target, prefix);

        prefix.put(currSum, prefix.get(currSum) - 1); // backtrack

        return count;
    }
}
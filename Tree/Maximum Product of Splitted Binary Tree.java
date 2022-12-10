1339. Maximum Product of Splitted Binary Tree
https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

/*
->Find the Total Sum of Binary Tree
->DFS the Tree, product = currSum * (totalSum-currSum)
->Find the maximum product at each node
*/
class Solution {
    long max;
    public int maxProduct(TreeNode root) {
        long totalSum = dfs(root);
        max = 0;
        helper(root, totalSum);
        return (int)(max%1000000007);
    }

    public long helper(TreeNode node, long totalSum) {
        if(node==null) {
            return 0;
        }
        long left = helper(node.left, totalSum);
        long right = helper(node.right, totalSum);

        long currSum = node.val + left + right;

        max = Math.max(max, (totalSum-currSum)*(currSum));

        return currSum;
    }

    public long dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }

        return node.val + dfs(node.left) + dfs(node.right);
    }
}

124. Binary Tree Maximum Path Sum
https://leetcode.com/problems/binary-tree-maximum-path-sum/
https://www.youtube.com/watch?v=TO5zsKtc1Ic

/*
https://www.youtube.com/watch?v=TO5zsKtc1Ic
->Ignore if child nodes have negative values
->Find leftsum & rightsum, check leftsum+rightsum+root.val > max, update max
->Check if Math.max(leftsum, rightsum)+root.val > max, update max
*/

class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
    int helper(TreeNode root)
    {
        if(root == null) return 0;
        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));
        int sum = leftSum+rightSum+root.val;
        max = Math.max(max, sum);
        
        return Math.max(leftSum, rightSum)+root.val;
    }
}

1448. Count Good Nodes in Binary Tree
https://leetcode.com/problems/count-good-nodes-in-binary-tree/

/*
1.Traverse throw tree, constantly keep track of current path maximum
    if root.val>=highest change the highest
*/
class Solution {
    public int goodNodes(TreeNode root) {
        int count = 0;
        count = helper(root, count, root.val);
        return count;
    }
    public int helper(TreeNode root, int count, int highest)
    {
        if(root==null) return count;
        if(root.val>=highest)
        { 
            count++;
            highest = root.val;
        }
        count = helper(root.left, count, highest);
        count = helper(root.right, count, highest);
        return count;
    }
}

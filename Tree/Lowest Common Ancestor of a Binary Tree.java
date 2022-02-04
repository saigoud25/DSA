236. Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
https://www.youtube.com/watch?v=cOjLyASDJcc

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;//If root is null return NULL
        //If p or q is root return root
        if(root==p || root==q) return root;
        
        //Traverse the tree root and left
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //If left returns NUll, then both p & q are in right so return right, viceversa
        if(left==null) return right;
        if(right==null) return left;
        
        return root;
    }
}

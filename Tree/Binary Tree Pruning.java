814. Binary Tree Pruning
https://leetcode.com/problems/binary-tree-pruning/

/*
->Traverse the Tree, if the left, right and root.val is 0 return the null
*/
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        root.left = pruneTree(root.left);
        
        root.right = pruneTree(root.right);
        
        if(root.left==null && root.right==null && root.val==0) {
            return null;
        }
        
        return root;
    }
}

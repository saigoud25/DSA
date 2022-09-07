606. Construct String from Binary Tree
https://leetcode.com/problems/construct-string-from-binary-tree/

/*
->If both left and right are null, just return the root.val
->If only right is null, return the modified string upto left
*/
class Solution {
    public String tree2str(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        if(root.left==null && root.right==null) {
            return root.val+"";
        }
        
        if(root.right==null) {
            return root.val + "(" + tree2str(root.left) + ")";
        } 
        
        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
    }
    
}

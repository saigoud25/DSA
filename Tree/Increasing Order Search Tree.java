/*
897. Increasing Order Search Tree
https://leetcode.com/problems/increasing-order-search-tree/

->Inorder traverse the tree, 
->Create the new tree
->Make the root.left null,
->Copy the root element to new tree and traverse right
*/

class Solution {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode temp = new TreeNode(0);
        cur = temp;
        inOrder(root);
        return temp.right;    
    }
    void inOrder(TreeNode root)
    {
        if(root == null) return;
        
        inOrder(root.left);
        root.left = null;
        cur.right = root;
        cur= root;
        inOrder(root.right);
        
        return;
    }
}

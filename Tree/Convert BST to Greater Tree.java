538. Convert BST to Greater Tree
https://leetcode.com/problems/convert-bst-to-greater-tree/submissions/


/*
->Reverse Inorder traverse the Tree
->Store the sum value in a global variable
*/
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        
        return root;
    }
}

101. Symmetric Tree
https://leetcode.com/problems/symmetric-tree/

/*
->Use Two pointers
->Check two pointer nodes, 
    ->if they are equal, Check root1.left and root2.right and
    ->Check root1.right and root2.left
    ->else return false
->If two pointers are null return false
    
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root, root);
    }
    boolean helper(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null) return true;
        else if(root1==null || root2==null) return false;
        
        if(root1.val!=root2.val) return false;
        boolean flag = helper(root1.left, root2.right);
        if(flag==true)
        {
            flag = helper(root1.right, root2.left);
        }
        return flag;
    }
}

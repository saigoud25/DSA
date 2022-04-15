669. Trim a Binary Search Tree
https://leetcode.com/problems/trim-a-binary-search-tree/submissions/

/*
https://youtu.be/bTA3OLAeTi4
->If node is lesser than the low, return the right node
->If node is higher than the high, return the left node
->If both conditions false, traverse and check Left side and Right side
*/
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {      
        if(root == null) return null;
        
        if(low>root.val)
        {
            return trimBST(root.right, low, high);
            
        }
        if(high<root.val)
        {

            return trimBST(root.left, low, high);
           
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}

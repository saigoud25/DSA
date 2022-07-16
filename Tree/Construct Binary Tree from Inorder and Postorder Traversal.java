106. Construct Binary Tree from Inorder and Postorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/


/*
->Using Divide and Conquer mothod, divide the each inorder and postOrder
*/
class Solution {
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        
        return helper(0, inorder.length-1, inorder, 0, postorder.length-1, postorder);
    }
    
    public TreeNode helper(int inStart, int inEnd, int[] inorder, int postStart, int postEnd, int[] postorder)
    {
        if(inStart>inEnd || postStart>postEnd) return null;
        
        TreeNode node = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(node.val);
        int length = inRoot - inStart;
        
        node.left = helper(inStart, inRoot-1, inorder, postStart, postStart+length-1, postorder);
        node.right = helper(inRoot+1, inEnd, inorder, postStart+length, postEnd-1, postorder);
        
        return node;
    }   
}

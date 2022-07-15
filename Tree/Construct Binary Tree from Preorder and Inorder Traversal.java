105. Construct Binary Tree from Preorder and Inorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
https://youtu.be/aZNaLrVebKQ


/*
https://youtu.be/aZNaLrVebKQ

->Divide and make each subparts as a tree
*/

class Solution {
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(0, inorder.length-1, 0, preorder.length-1, inorder, preorder);
        return root;
    }
    
    public TreeNode helper(int inStart, int inEnd, int preStart, int preEnd, int[] inorder, int[] preorder)
    {
        if(inStart>inEnd || preStart>preEnd) return null;
        
        TreeNode node = new TreeNode(preorder[preStart]);
        
        int inRoot = map.get(node.val);
        int inLeft = inRoot - inStart;
        
        TreeNode left = helper(inStart, inRoot-1, preStart+1, preStart+inLeft, inorder, preorder);
        TreeNode right = helper(inRoot+1, inEnd, preStart+inLeft+1, preEnd, inorder, preorder);
        
        node.left = left;
        node.right = right;
        
        return node;
    }
}

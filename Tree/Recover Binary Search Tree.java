99. Recover Binary Search Tree
https://leetcode.com/problems/recover-binary-search-tree/

/*
Method-1: Using Morris Inorder Tree Traversal Method
Method-2: Inorder Traversal
->Inorder traverse the Tree and store the nodes in an ArrayList
->Normal Inorder traversal gives ascending order list
->The two node values don't follow ascending order
->Swap values of those both nodes
*/
class Solution {
    public void recoverTree(TreeNode root) {
        //Method-2
        ArrayList<TreeNode> arr = new ArrayList<>();
        TreeNode x = null, y = null;
        helper(root, arr);
        for(int i = 1; i<arr.size(); i++)
        {
            if(arr.get(i).val<arr.get(i-1).val)
            {
                x = arr.get(i);
                if(y==null)
                {
                    y = arr.get(i-1);
                }
            }
        }
        int ele = x.val;
        x.val = y.val;
        y.val = ele;
    }
    public void helper(TreeNode root, ArrayList<TreeNode> arr)
    {
        if(root==null) return;
        helper(root.left, arr);
        arr.add(root);
        helper(root.right, arr);
        return;
    }
}

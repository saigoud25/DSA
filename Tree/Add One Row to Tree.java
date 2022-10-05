623. Add One Row to Tree
https://leetcode.com/problems/add-one-row-to-tree/

/*
->Traverse left and right, if depth is 1 create left and right nodes and assign node.left and node.right
*/
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //To avoid the edge case
        if(depth==1) {
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        dfs(root, val, depth-1);
        return root;
    }
    
    public void dfs(TreeNode node, int val, int depth) {
        //Base Condition
        if(depth == 1) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = node.left;
            right.right = node.right;
            
            node.left = left;
            node.right = right;
            
            return;
        }
        
        if(node.left != null) {
            dfs(node.left, val, depth-1);
        }
        
        if(node.right != null) {
            dfs(node.right, val, depth-1);
        }
    }
}

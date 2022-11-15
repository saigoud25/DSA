222. Count Complete Tree Nodes
https://leetcode.com/problems/count-complete-tree-nodes/

/*
->Check the Root left and right height is same
->If both heights are same return 2^h-1
->Else find left elements + 1 + right elements
*/
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        int[] arr = checkHeight(0, root.left, root.right);
        
        if(arr[0] == 1) {
            return (2<<arr[1]) - 1;
        }
        
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
    
    public int[] checkHeight(int h, TreeNode left, TreeNode right) {
        if(left==null && right==null) {
            return new int[]{1, h};
        } else if(left==null || right==null) {
            return new int[]{0, h};
        }
        
        return checkHeight(h+1, left.left, right.right);
    }
}

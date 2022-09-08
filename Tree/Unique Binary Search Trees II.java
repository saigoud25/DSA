95. Unique Binary Search Trees II
https://leetcode.com/problems/unique-binary-search-trees-ii/
https://youtu.be/mhCJgZWJlSI

/*
->Using Divide and Conquer
https://youtu.be/mhCJgZWJlSI

->First create 1 to i-1, and i+1 to end nodes
->combine left and right nodes, as total number of nodes is left*right
*/

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        
        //Base Cases
        if(start > end) {
            list.add(null);
            return list;
        }
        
        if(start==end) {
            list.add(new TreeNode(start));
            return list;
        }
        
        for(int i = start; i<=end; i++) {
            List<TreeNode> leftTrees = helper(start, i-1);
            List<TreeNode> rightTrees = helper(i+1, end);
            
            for(TreeNode left : leftTrees) {
                for(TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        
        return list; 
    }
}

653. Two Sum IV - Input is a BST
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

/*
->Using a set store the traversed node values
->If k-node.val is present in the set return true
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        return dfs(root, set, k);
    }
    
    public boolean dfs(TreeNode node, HashSet<Integer> set, int k) {
        if(node == null) {
            return false;
        }
        
        if(set.contains(k-node.val)) {
            return true;
        }
        
        set.add(node.val);
        
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }
}

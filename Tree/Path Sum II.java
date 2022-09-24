113. Path Sum II
https://leetcode.com/problems/path-sum-ii/

/*
->Traverse the Tree by adding node value and remove the node value after left/right traversal
*/
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();

        dfs(targetSum, root, new ArrayList<>());
        
        return res;
    }
    
    void dfs(int target, TreeNode node, ArrayList<Integer> list) {
        if(node == null) {
            return;
        }
        
        list.add(node.val);
        
        if(node.left==null && node.right==null) {
            if(target==node.val) {
                res.add(new ArrayList(list));
            }
            
            return;
        }
        
        if(node.left != null) {
            dfs(target-node.val, node.left, list);
            list.remove(list.size()-1);
        }
        
        if(node.right != null) {
            dfs(target-node.val, node.right, list);
            list.remove(list.size()-1);
        }
    }
}

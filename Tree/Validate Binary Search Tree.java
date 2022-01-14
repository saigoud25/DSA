98. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/
50%

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr = helper(root, arr);
        
        for(int i = 1; i<arr.size(); i++)
        {
            if(arr.get(i-1)>=arr.get(i)) return false;
        }
        
        return true;
    }
    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> arr)
    {
        if(root == null) return arr;
        
        arr = helper(root.left, arr);
        arr.add(root.val);
        arr = helper(root.right, arr);
        
        return arr;
    }
}

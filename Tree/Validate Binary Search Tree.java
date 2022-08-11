98. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/

/*
Method-1
->Inorder Traverse the Tree and store the elements in the ArrayList
->If the elements in the arraylist are not sorted order then it's not a valid BST

Method-2
->Maintain two values min and max
->Check whether the root.val is between two values, else return false
->While calling the left/right trees update the min/max with root.val

*/
//Method-1
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return helper(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
    public boolean helper(long min, long max, TreeNode root) {
        if(root==null) return true;
        
        if((min >= root.val) || (max <= root.val)) return false;
        
        return helper(min, root.val, root.left) && helper(root.val, max, root.right);
    }
} 
    
    
//Method-2   
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

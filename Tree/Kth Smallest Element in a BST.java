230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
50%

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
      
        ArrayList<Integer> arr = new ArrayList<>();
        arr = helper(root, arr, k);
        int ele = arr.get(k-1);
      
        return ele;
    }
    
    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> arr, int k)
    {
        if(root == null || arr.size()>k) return arr;
        
        arr = helper(root.left, arr, k);
        arr.add(root.val);
        k++;
        arr = helper(root.right, arr, k);
        
        return arr;
    }
}

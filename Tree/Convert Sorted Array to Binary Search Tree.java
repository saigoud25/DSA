108. Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


/*
->Make middle element as root,
->start to mid-1 as left
->mid+1 to end as right
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
        //Base Case
        if(start > end) {
            return null;
        }
        
        int mid = (start+end)/2;
        
        TreeNode left = helper(nums, start, mid-1);
        TreeNode right = helper(nums, mid+1, end);
        
        TreeNode root = new TreeNode(nums[mid], left, right);
        
        return root;
    }
}

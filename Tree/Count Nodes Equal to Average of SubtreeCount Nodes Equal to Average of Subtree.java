2265. Count Nodes Equal to Average of Subtree
https://leetcode.com/contest/weekly-contest-292/problems/count-nodes-equal-to-average-of-subtree/


/*
->Inorder traverse the Tree,
->If root node reached return the array, which has [0, 0]
->arr[] = {0, 0}, arr[1] represents the total sum of root and arr[1] represents the total number of nodes
->To find the total sum, add left[0]+right[0]+root.val
->To find total elements in the subtree, add left[1]+right[1]+1
->Divide TotalSum/TotalElements to find all Nodes Equal to Average of Subtree, If equal increment ans by 1
->return the array of totalsum and total elements
*/

class Solution {
    
    int ans = 0;
    int[] arr = new int[2];
    
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        
        return ans;
    }
    
    int[] helper(TreeNode root)
    {
        if(root==null)
        {
            return new int[2];
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int sum = left[0]+right[0]+root.val;
        
        int totalElements = left[1]+right[1]+1;
        
        if(root.val==(sum/totalElements)) ans++;
        
        return new int[]{sum, totalElements};
    }
}
/*
->Inorder traverse the Tree,
->If root node reached return the array, which has [0, 0]
->arr[] = {0, 0}, arr[1] represents the total sum of root and arr[1] represents the total number of nodes
->To find the total sum, add left[0]+right[0]+root.val
->To find total elements in the subtree, add left[1]+right[1]+1
->Divide TotalSum/TotalElements to find all Nodes Equal to Average of Subtree, If equal increment ans by 1
->return the array of totalsum and total elements
*/

class Solution {
    
    int ans = 0;
    int[] arr = new int[2];
    
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        
        return ans;
    }
    
    int[] helper(TreeNode root)
    {
        if(root==null)
        {
            return new int[2];
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int sum = left[0]+right[0]+root.val;
        
        int totalElements = left[1]+right[1]+1;
        
        if(root.val==(sum/totalElements)) ans++;
        
        return new int[]{sum, totalElements};
    }
}

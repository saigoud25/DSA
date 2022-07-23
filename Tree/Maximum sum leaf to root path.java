Maximum sum leaf to root path
https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1

/*
->Traverse to the Null nodes, return 0 if root is null
->At each node return the Math.max(left, right)+root.data
*/

class Solution
{
    public static int maxPathSum(Node root)
    {
        //code here
        if(root==null) {
            return 0;
        }
        
        int left = maxPathSum(root.left);
        
        int right = maxPathSum(root.right);
        
        return Math.max(left, right)+root.data;
    }
}

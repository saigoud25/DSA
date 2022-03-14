Sum Tree
https://practice.geeksforgeeks.org/problems/sum-tree/1#

/*
->Return root.data if left and right nodes are null
->If leftSum+rightSum == root.data return, whole sum
->Else return -1    
*/
class Solution
{
	boolean isSumTree(Node root)
	{
        // Your code here
        int ans = helper(root);
        if(ans==-1) return false;
        return true;    
	}
	int helper(Node root)
	{
	    if(root == null)
	    {
	        return 0;
	    }
	    if(root.left==null && root.right==null) return root.data;
	    
	    int leftSum = helper(root.left);
	    int rightSum = helper(root.right);
	    
	    if(leftSum==-1 || rightSum==-1) return -1;
	    
	    if(leftSum+rightSum == root.data)
	    {
	        return leftSum+rightSum+root.data;
	    }
	    return -1;
	}
}

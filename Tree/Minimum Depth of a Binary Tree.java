Minimum Depth of a Binary Tree
https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1/

/*
->Don't count for null node
*/
class Solution
{
	int minDepth(Node root)
	{
	    //code here
	   // if(root==null) return 0;
	    
	    if(root.left==null && root.right==null)
	    {
	        return 1;
	    }
	    int left = Integer.MAX_VALUE;
	    int right = Integer.MAX_VALUE;
	    
	    if(root.left!=null)
	    {
	        left = minDepth(root.left);
	    }
	    if(root.right!=null)
	    {
	        right = minDepth(root.right);
	    }
	    
	    
	    return (Math.min(left, right)+1);
	    
	}
}

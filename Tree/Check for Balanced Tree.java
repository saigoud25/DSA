Check for Balanced Tree
https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1#

/*
->If the differences between height of left child and right child is 1, return true
*/
class Tree
{
//Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
	// Your code here
	    if(root==null) return true;
	    
	    int leftTree = height(root.left);
	    int rightTree = height(root.right);

	   return (Math.abs(leftTree-rightTree)<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }
    int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(height(root.left), height(root.right));
    }
}

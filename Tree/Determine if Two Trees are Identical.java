Determine if Two Trees are Identical
https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

/*
->Check for base conditions, if both are null return true, if any one is null return false
->Check for left nodes and right nodes
*/

class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    if(root1==null && root2==null) return true;
	    
	    if(root1==null || root2==null) return false;
	    
	    if(root1.data != root2.data) return false;
	    
	    return (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
	}
}

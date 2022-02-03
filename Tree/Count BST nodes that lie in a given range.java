Count BST nodes that lie in a given range
https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1

/*
Traverse through tree, if node.data in range increment count;
used count array instead of global element;
*/

class Tree
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        //Your code here
        int[] count = {0};
        count = helper(root, l, h, count);
        return count[0];
    }
    int[] helper(Node root, int l, int h, int[] count)
    {
        if(root==null) return count;
        if(l<=root.data && root.data<=h)
        {
            count[0] = count[0]+1;
        }
        helper(root.left, l, h, count);
        helper(root.right, l, h, count);
        return count;
    }
}

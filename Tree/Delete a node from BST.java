Delete a node from BST
https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1/#
/*
https://youtu.be/petKaikRiIA
->Simply delete the node if left or right is null,
    ->If left is null return right
    ->If right is null return left
->If both left and right of X node is not null
    ->First find the min value in the right of X node
    ->Replace X.data with min value
    ->Now delete that min valued node in the right of X node

*/
class Tree {
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int X) {
        // code here.
        if(root==null) return root;
        
        if(X < root.data)
        {
            root.left = deleteNode(root.left, X);
        }
        else if(X > root.data)
        {
            root.right = deleteNode(root.right, X);
        }
        else
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            root.data = minVal(root.right);
            
            root.right = deleteNode(root.right, root.data);
            
        }
        
        return root;
    }
    
    static int minVal(Node root)
    {
        int min = root.data;
        
        while(root.left != null)
        {
            root = root.left;
            min = root.data;
        }
        
        return min;
    }
}

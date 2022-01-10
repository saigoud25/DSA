Tree: Preorder Traversal
https://www.hackerrank.com/challenges/tree-preorder-traversal/

public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        if(root.left != null)
        {
            preOrder(root.left);
        }
        if(root.right != null)
        {
            preOrder(root.right);
        }
        
}
--------------------------------------------------------------------------

InOrder Traversal
https://www.hackerrank.com/challenges/tree-inorder-traversal/

public static void inOrder(Node root) {
        if(root == null) return;
        
        if(root.left != null)
        {
            inOrder(root.left);
        }
        System.out.print(root.data+" ");
        if(root.right != null)
        {
            inOrder(root.right);
        }
}

---------------------------------------------------------------------------

PostOrder Traversal
https://www.hackerrank.com/challenges/tree-postorder-traversal/

public static void postOrder(Node root) {
        if(root == null) return;
        
        if(root.left != null)
        {
            postOrder(root.left);
        }
        if(root.right != null)
        {
            postOrder(root.right);
        }
        System.out.print(root.data+" ");
}

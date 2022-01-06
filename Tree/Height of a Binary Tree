Tree: Height of a Binary Tree


https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/

/*
    class Node 
    	int data;
    	Node left;
    	Node right;
*/

public static int height(Node root) {
      	// Write your code here.
          if(root == null)
          {
              return -1;
          }
          else
          {
              int leftChild = height(root.left);
              int rightChild = height(root.right);
              
              return Math.max(leftChild+1, rightChild+1);
          }
          
}

Delete nodes greater than k
https://practice.geeksforgeeks.org/problems/delete-nodes-greater-than-k/1


class Solution
{
     public Node deleteNode(Node root,int k)
     {
     //add code here.
         if(root==null) return null;
         
         if(root.data >= k) {
             root = deleteNode(root.left, k);
         }
         else {
             root.right = deleteNode(root.right, k);
         }
         
         return root;
     }
}

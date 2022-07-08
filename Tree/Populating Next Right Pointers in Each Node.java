116. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
->Level order traverse the Tree
->At each node join the curr.left and curr.right and
    ->Check whether curr.next is null, if not null
    ->Join the curr.right and curr.next.left
->Each iteration should be start from the starting of the level(levelNode)

*/
class Solution {
    public Node connect(Node root) {
        Node levelNode = root;
        while(levelNode != null)
        {
            Node curr = levelNode;
            while(curr != null)
            {
                if(curr.left != null) curr.left.next = curr.right;
                if(curr.right != null && curr.next != null) curr.right.next = curr.next.left; 
                
                curr = curr.next;
            }
            levelNode = levelNode.left;
        }
        return root;
    }
}

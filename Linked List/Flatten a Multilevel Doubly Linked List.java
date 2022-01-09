430. Flatten a Multilevel Doubly Linked List
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

class Solution {
    public Node flatten(Node head)
    {
        if(head == null) return head;
        Node curr = head;
        
        while(curr != null)
        {
            /* CASE 1: if no child, proceed */
            if(curr.child == null)
            {
                curr = curr.next;
                continue;
            }
            
            
            /* CASE 2: got child, find the tail of the child and link it to curr.next */ 
            // Find the tail of the child
            Node temp = curr.child;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            
            // Connect tail with curr.next, if it is not null 
            temp.next = curr.next;
            if(curr.next != null)
            {
                curr.next.prev = temp;
            }
            
            // Connect curr with curr.child, and remove curr.child
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
            }
            return head;
        }
}

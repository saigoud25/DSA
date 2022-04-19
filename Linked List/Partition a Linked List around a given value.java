/*
Partition a Linked List around a given value
https://practice.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1#

->Create 3 LinkedLists and dummy nodes for them
->Less list stores nodes lesser than x
->Equal nodes stores nodes equal to x
->Great nodes stores nodes greater than x
->join all 3 LinkedLists
*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        Node ld = new Node(0);
        Node ed = new Node(0);
        Node gd = new Node(0);
        Node d = new Node(0);
        Node less = ld;
        Node equal = ed;
        Node great = gd;
        
        while(node != null)
        {
            Node temp = new Node(node.data);
            if(temp.data < x)
            {
                less.next = temp;
                less = less.next;
            }
            else if(temp.data > x)
            {
                great.next = temp;
                great = great.next;
            }
            else
            {
                equal.next = temp;
                equal = equal.next;
            }
            node = node.next;
        }
        
        if(ed.next != null)
        {
            less.next = ed.next;
            if(gd != null)
            {
                equal.next = gd.next;
            }
        }
        else if(gd != null)
        {
            less.next = gd.next;
        }
        
        return ld.next;
    }
}

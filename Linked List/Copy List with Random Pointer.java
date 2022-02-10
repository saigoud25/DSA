138. Copy List with Random Pointer
https://leetcode.com/problems/copy-list-with-random-pointer/
https://youtu.be/4apaOcK586U

/*
https://youtu.be/4apaOcK586U
-> Insert new temp nodes between head and head.next
-> update random nodes
-> remove links from original list
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node dummy = new Node(0);
        Node d = new Node(0);
        dummy.next = head;
        //Insertig temp nodes betwenn head and head.next
        while(head!=null)
        {
            Node temp = new Node(head.val);
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
        head = dummy.next;
        
        //Updating head.random nodes
        //temp.next.random = head.random
        while(head!=null)
        {
            if(head.random==null)
            {
                head.next.random = null;
            }
            else{head.next.random = head.random.next;}
            head = head.next.next;
        }

        //Removing all linkes with original nodes
        head = dummy.next;
        Node curr = head.next;
        Node ret = curr;
        while(head!=null)
        {
            if(head.next.next==null)
            {
                head.next = null;
                curr.next = null;
                break;
            }
            head.next = head.next.next;
            curr.next = head.next.next;
            curr = curr.next;
            head = head.next;
        }
        return ret;
    }
}

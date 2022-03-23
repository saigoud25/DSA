Swap Kth nodes from ends
https://practice.geeksforgeeks.org/problems/swap-kth-node-from-beginning-and-kth-node-from-end-in-a-singly-linked-list/1

/*
->Use 4 pointers to swap, by checking edge cases
*/
class GFG
{
    //Function to swap Kth node from beginning and end in a linked list.
    Node swapkthnode(Node head, int num, int K)
    {
        // your code here
        if(head==null) return head;
        if(k>n) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        int count = 1;
        Node left = head;
        Node lprev = null;
        Node right = head;
        Node rprev = null;
        
        for(int i = 1; i<k; i++)
        {
            lprev = left;
            left = left.next;
        }
        for(int i = 1; i<n-k+1; i++)
        {
            rprev= right;
            right = right.next;
        }
        // System.out.println("left-"+left.data);
        // System.out.println("lprev-"+lprev.data);
        // System.out.println("right-"+right.data);
        // System.out.println("rprev-"+rprev.data);
        
        if(lprev != null) lprev.next = right;
        if(rprev != null) rprev.next = left;
        Node temp = left.next;
        left.next = right.next;
        right.next = temp;
        
        if(k==1) return right;
        if(k==n) return left;
        
        return head;
    }
}

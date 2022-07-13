Remove duplicate element from sorted Linked List
https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1/

/*
->Create a temp variable which stores the current node's data
->Check the temp with head.next.data,
    ->If both are equal point the head.next to the head.next.next
    ->Else make head as head.next and update temp as head.data
*/
class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	// Your code here	
	    Node dummy = new Node(0);
	    dummy.next = head;
	    int temp = head.data;
	
	    while(head.next != null)
	    {
	        if(head.next.data==temp)
	        {
	            head.next = head.next.next;
	        }
	        else
	        {
	            head = head.next;
	            temp = head.data;
	        }
	    }
	    
	    return dummy.next;
    }
}

92. Reverse Linked List II
https://leetcode.com/problems/reverse-linked-list-ii/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return head;
        
        //Create dummy node and point it to head, and return dummy.next
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, leftPrev = dummy; 
        
        //find the previous node of left
        for(int i = 0; i<left-1; i++)
        {
            leftPrev = curr;
            curr = curr.next;
        }
        
        //reverse  List from left to right
        //curr -> left(2), leftPrev -> node before left(1)
        ListNode prev = null, Next = null;
        for(int i = 0; i<(right-left)+1; i++)
        {
            Next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = Next;
        }
        
        //Now prev->right(4), curr->next of right(5)
        //Update Pointers
        leftPrev.next.next = curr;
        leftPrev.next = prev;
 
        return dummy.next;
    }
}

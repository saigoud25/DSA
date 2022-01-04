206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
https://www.youtube.com/watch?v=ugQ2DVJJroc


//Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode current = head;
        ListNode prev = null;
        
        while(current != null)
        {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
}

//Recursion
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode newHead = reverseList(head.next);
        ListNode nextHead = head.next;
        
        nextHead.next = head;
        head.next = null;
        
        return newHead; 

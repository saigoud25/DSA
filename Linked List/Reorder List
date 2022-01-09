143. Reorder List
https://leetcode.com/problems/reorder-list/

1)split linkedlist into two halves
  -find mid and split
  -and revese second half
2)merge these two halves

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode nextMid, midNode = findMid(head);
        nextMid = midNode.next;
        midNode.next = null;
        ListNode rev = reverse(nextMid);
        
        ListNode temp = head, next;
        while(temp!=null && rev!=null)
        {
            next = temp.next;
            temp.next = rev;
            
            temp = rev;
            rev = next;
            
        }
       
    }
    
    public ListNode reverse(ListNode head)
    {
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
    
    public ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}

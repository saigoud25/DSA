142. Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/

/*
->https://youtu.be/QfbOhn0WZ88
->Use slow and fast pointers, if they meet at a place loop exists else return null
->Now traverse slow and entry by 1, if they meet that point is the starting point of the list
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow = head, fast = head, entry = head;
        
        while(fast.next != null && fast.next.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast) {
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                } 
                
                return entry;
            }
        }
        return null;
    }
}

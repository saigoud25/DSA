876. Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        ListNode fast = head;
        
        while(fast != null)
        {
            if(fast.next != null)
            {
                fast = fast.next.next;
                curr = curr.next;
            }
            else
            {
                return curr;
            }
        }
        
        return curr;
    }
}

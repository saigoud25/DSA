19. Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/*
->Use two pointers
->The distance between two pointers is size n
->first traverse starting n nodes with head,
->after reaching n nodes parallally start the slow pointer
->when head reaches the null, slow pointer is 'n' distance long from end
->remove/delete the next node of slow, slow.next = slow.next.next
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        int count = 1;
        while(count<n)
        {
            count++;
            head = head.next;
        }
        while(head.next!=null)
        {
            slow = slow.next;
            head = head.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

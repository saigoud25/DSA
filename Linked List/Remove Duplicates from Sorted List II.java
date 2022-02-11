82. Remove Duplicates from Sorted List II
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

/*
->Use prev node, traverse until head is not null
->If node.val==node.next.val traverse until last duplicate node
->Then make prev.next = head.next
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while(head!=null)
        {
            if(head.next!=null && head.val==head.next.val)
            {
                while(head.next!=null && head.val==head.next.val)
                {
                    head = head.next;
                }
                prev.next = head.next;
            }
            else
            {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}

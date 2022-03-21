24. Swap Nodes in Pairs
https://leetcode.com/problems/swap-nodes-in-pairs/
https://youtu.be/WYlMkut4XDw

/*
https://youtu.be/WYlMkut4XDw
->Maintain Current and prev pointers
->Swap to pairs 
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(0, head), prev = dummy, current = head;
        
        while(current!=null && current.next!=null)
        {
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = current;
            current = current.next;
            prev = prev.next.next;
        }
       
        return dummy.next;
    }
}

86. Partition List
https://leetcode.com/problems/partition-list/

/*
->Use two pointers small and big
->Small contains smaller nodes less than x
->Big contains nodes equal to or greater than x
->Merge both lists
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), big = new ListNode(0);
        ListNode s = small;        
        ListNode b = big;
        while(head!=null)
        {            
            if(head.val<x)
            {
                small.next = head;
                small = small.next;
            }
            else
            {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        //connecting two nodes
        big.next = null;
        small.next = b.next;

        return s.next;
    }
}

2. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/

/*
traverse two linkedlists 
-> add first+second+carry
-> if sum is greater than 10, then keep carry as 1 and make sum%10 create a new node with it
-> increment l1, l2 and temp lists to their next positions
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode send = temp;
        int carry = 0, first = 0, second = 0;
        while(l1!=null || l2!=null)
        {
            if(l1!=null)
            {
                first = l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                second = l2.val;
                l2 = l2.next;
            }
            int t = first+second+carry;
            carry = 0;
            first = 0;
            second = 0;
            if(t>=10)
            {
                carry = 1;
                t = t%10;
            }
            ListNode node = new ListNode(t);
            temp.next = node;
            temp = temp.next;
        }
        if(carry!=0)
        {
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        return send.next;
    }
}

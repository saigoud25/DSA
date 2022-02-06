61. Rotate List
https://leetcode.com/problems/rotate-list/

/*
->find the length of list
->if k=2, we have to cut last 2 nodes and paste them before head
->if k>count, cut count-(k%count) nodes
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode curr = head;
        ListNode temp = new ListNode();
        int count = 0, i = 1;
        while(curr!=null)
        {
            curr = curr.next;
            count++;
        }
        if(k%count==0) return head; 
        count = count - (k%count);
        curr = head;
        while(curr!=null ||i<=count)
        {
            if(i==count)
            {
                temp = curr.next;
                curr.next = null;
                break;
            }
            i++;
            curr = curr.next;
        }
        ListNode t = temp;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = head;
        return t;
    }
}

2130. Maximum Twin Sum of a Linked List
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/submissions/

/*
->Find the mid using slow-fast pointers, at the same time reverse the traversed list
->At the middle, prev points to left nodes in reverse order and curr points right side elements
->Now traverse through the prev and curr nodes and add the values and compare with the sum
*/
class Solution {
    public int pairSum(ListNode head) {
        ListNode curr = head, slow = head, fast = head;
        ListNode prev = null;
        int sum = 0;
        
        while(fast != null)
        {
            fast = fast.next.next;
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = temp;
        }
        
        while(prev!=null)
        {
            sum = Math.max(sum, (prev.val+curr.val));

            prev = prev.next;
            curr = curr.next;
        }
        
        return sum;
    }
}

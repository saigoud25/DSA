1019. Next Greater Node In Linked List
https://leetcode.com/problems/next-greater-node-in-linked-list/


/*
Method-1: Bruteforce
->from head check the next greater node
->increment head by 1
*/

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList();
        ListNode d = new ListNode();
        d.next = head;
        while(head != null)
        {
            int ele = helper(head);
            arr.add(ele);
            head = head.next;
        }
        int[] temp = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++)
        {
            temp[i] = arr.get(i);
        }
        return temp;
    }
    int helper(ListNode head)
    {
        int ele = head.val;
        while(head!=null)
        {
            if(head.next!=null)
            {
                if(ele<head.next.val)
                {
                    return head.next.val;
                }
            }
            head = head.next;
        }
        return 0;
    }
}

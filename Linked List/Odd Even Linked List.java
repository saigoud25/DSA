328. Odd Even Linked List
https://leetcode.com/problems/odd-even-linked-list/

/*
->Use two pointers odd and even
->While traversing add odd indexed nodes to odd list and even indexed nodes to even
->Merge odd and even
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(0), odd = new ListNode(0);
        ListNode evenHead = even;        
        ListNode oddHead = odd;
        boolean flag = true;
        while(head!=null)
        {            
            if(flag)
            {
                odd.next = head;
                odd = odd.next;
            }
            else
            {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            flag = !flag;
        }
        //connecting two nodes
        even.next = null;
        odd.next = evenHead.next;

        return oddHead.next;
    }
}

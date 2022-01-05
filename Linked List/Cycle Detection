Cycle Detection
https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/
https://www.youtube.com/watch?v=jcZtMh_jov0


static boolean hasCycle(SinglyLinkedListNode head) {
        
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
            {
                return true;
            }
        }
        
        return false;
}

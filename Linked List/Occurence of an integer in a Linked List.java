Occurence of an integer in a Linked List
https://practice.geeksforgeeks.org/problems/occurence-of-an-integer-in-a-linked-list/1

/*
1.Traverse the list till null, if head.data is search key then increment count
*/
class Solution
{
    public static int count(Node head, int search_for)
    {
        //code here
        int count = 0;
        while(head!=null)
        {
            if(head.data==search_for) count++;
            head = head.next;
        }
        return count;
    }
}

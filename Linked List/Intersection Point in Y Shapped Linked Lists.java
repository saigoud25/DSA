Intersection Point in Y Shapped Linked Lists
https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1


/*
->Find the lengths of head1 & head2
->Traverse longest list to small list
->Now compare both heads if found both heads are equal return head1.data
*/
class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         Node d1 = new Node(0), d2 = new Node(0);
         d1.next = head1;
         d2.next = head2;
         int count_h1 = 0, count_h2 = 0;
         while(head1!=null)
         {
            count_h1++;
            head1 = head1.next;
         }
         while(head2!=null)
         {
            count_h2++;
            head2 = head2.next;
         }
         int n = 0;
         if(count_h1>count_h2)
         {
             n = count_h1-count_h2;
             head1 = d1.next;
             head2 = d2.next;
         }
         else
         {
             n = count_h2-count_h1;
             head1 = d2.next;
             head2 = d1.next;
         }
         for(int i = 0; i<n; i++)
         {
             head1 = head1.next;
         }

         while(head1!=null && head2!=null)
         {
             if(head1 == head2)
             {
                return head1.data;
             }
             
             head1 = head1.next;
             head2 = head2.next;
         }
         
         return -1;
	}
}

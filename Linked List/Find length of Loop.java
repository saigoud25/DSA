Find length of Loop
https://practice.geeksforgeeks.org/problems/find-length-of-loop/1#

/*
->Add the node into HashMap, node as key and it's index as a value
->If the HashMap contains the node, return the cuurent index-previos index
*/
class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        HashMap<Node, Integer> map = new HashMap<>();
        int i = 1;
        while(head != null)
        {
            if(map.containsKey(head))
            {
                return i-map.get(head);
            }
            map.put(head, i);
            i++;
            head = head.next;
        }
        
        return 0;
    }
}

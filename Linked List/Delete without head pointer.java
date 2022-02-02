Delete without head pointer
https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1/

/*
[1] -> [2(3)] -> [3]->[4]->[5]
        /   \ 
temp->[3] -> [4] -> [5]->[6]
*/

class Solution
{
    void deleteNode(Node del)
    {
         Node temp = del.next;
         del.data = temp.data;
         del.next = temp.next;
    }
}

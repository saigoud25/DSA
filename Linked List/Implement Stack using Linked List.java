Implement Stack using Linked List 
https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1

/*
Insert nodes in reverse order
1.Push:
    ->Create a temp node with given data
    ->If list is empty make temp as a top
    ->now temp.next points to top and make top as temp
2.Pop:
    ->If list is empty return -1
    ->Create a temp, temp = top
    ->temp.next points to top
    -> make top.next as null and return top.data
*/
class MyStack 
{
    StackNode top;
    //Function to push an integer into the stack.
    void push(int a) 
    {
        // Add your code here
        StackNode temp = new StackNode(a);
        if(top==null || top.next==null)
        {
            top = temp;
        }
        temp.next = top;
        top = temp;
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        // Add your code here
        if(top==null) return -1;
        else if(top.next==null) return -1;
        StackNode temp = top;
        top = temp.next;
        temp.next = null;
        return temp.data;
    }
}

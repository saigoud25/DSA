Queue using two Stacks
https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1#


/*
1.Push 
->push element directly into stack-1
2.Pop
->Remove all elements from stack-1 and insert into stack-2, 
->Pop an element and store in variable
->Remove all elements from stafck-2 and insert into stack-1
->Return the stored variable
*/
class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
	   // Your code here
	    s1.push(x);
    }
	
    
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
	   // Your code here
	   if(s1.isEmpty())
	   {
	       return -1;
	   }
	   while(!s1.isEmpty())
	   {
	       s2.push(s1.pop());
	   }
	   int ele = s2.pop();
	   while(!s2.isEmpty())
	   {
	       s1.push(s2.pop());
	   }
	   return ele;
    }
}

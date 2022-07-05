Delete middle element of a stack
https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1/


/*
->Find the mid of the stack
->Remove and store the elements in variable until  the mid, each recursion call decrement the i
->If the i==1, pop the element in the stack and return the function
*/

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        // midDelete(s, sizeOfStack-(sizeOfStack/2));
        midDelete(s, sizeOfStack/2+1);
    } 
    
    public void midDelete(Stack<Integer> s, int i)
    {
        if(i==1)
        {
            s.pop();
            return;
        }
        
        int ele = s.pop();
        midDelete(s, i-1);
        s.push(ele);
        return;
    }
}

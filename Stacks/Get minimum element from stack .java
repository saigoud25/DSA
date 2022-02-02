Get minimum element from stack 
https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1/

/*
s -> storing original stack elements
temp -> storing only minimum elements
1.Push:
    -> store the 'x' in the stack.
    -> if 'x' is less than the min, swap min with x and push it into temp stack
2.Pop:
    ->If 's' is empty return '-1' and change 'min' to max value
    ->else pop from 's' and store it in 'ele' 
    ->If ele is equal to min, then pop element from temp.
    ->use top element from temp as a min
3.getMin:
     ->If 's' is empty return '-1' and change 'min' to max value
     ->else return min 
*/
class GfG
{
    int min = Integer.MAX_VALUE;
    Stack<Integer> s = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int getMin()
    {
	    if(s.isEmpty())
	    {
	        min = Integer.MAX_VALUE;
	        return -1;
	    }
	    return min;
    }
    int pop()
    {
	    if(s.isEmpty())
	    {
	        min = Integer.MAX_VALUE;
	        return -1;
	    }
	    int ele = s.pop();
	    if(!temp.isEmpty())
	    {
	        if(ele == temp.peek())
	        {
	            temp.pop();
	            if(!temp.isEmpty()) min = temp.peek();
	        }
	    }
	    if(s.isEmpty()) min = Integer.MAX_VALUE;
	    return ele;
    }
    void push(int x)
    {
	    s.push(x);
	    min = Math.min(min, x);
	    if(min == x)
	    {
	        temp.push(x);
	    }
    }	
}

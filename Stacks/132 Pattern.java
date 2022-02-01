456. 132 Pattern
https://leetcode.com/problems/132-pattern/

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack();
        int second = Integer.MIN_VALUE;
        
        //traverse from backside
        //i will be the current position
        //second is the recent popped element from stack
        //stack contains greater elements than second
        //i.e arr[i] < stack elements > second
        for(int i = nums.length-1; i>=0; i--)
        {
            if(nums[i]<second) return true;
            
            //if the arr[i] is greater than top of stack, 
            //pop elements until arr[i] less than top of the stack
            while(!st.isEmpty() && nums[i] > st.peek())
            {
                second = st.pop();
            }
            st.push(nums[i]);
        }
        
        return false;
    }
}

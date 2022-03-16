946. Validate Stack Sequences
https://leetcode.com/problems/validate-stack-sequences/

/*
->Traverse pushed ans push value into stack
->If top element of stack is equal to element of popped array, pop the stack
*/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack();
        int N = pushed.length;
        int j = 0;
        for(int i : pushed)
        {
            st.push(i);
            while(!st.isEmpty() && j<N && st.peek()==popped[j])
            {
                st.pop();
                j++;
            }
        }
        
        return j==N;
    }
}

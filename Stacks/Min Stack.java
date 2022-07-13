155. Min Stack
https://leetcode.com/problems/min-stack/

/*
->Create a stack, which stores all the elements
->Create an another stack (min stack), which pushes only min values into the stack (eg: 5, 3, 2, 1)
*/
class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty() || min.peek() >= val) 
        {
            min.push(val);
        }
    }
    
    public void pop() {
        int ele = st.pop();
        if(min.peek()==ele) min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

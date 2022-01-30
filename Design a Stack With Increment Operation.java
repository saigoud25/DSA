1381. Design a Stack With Increment Operation
https://leetcode.com/problems/design-a-stack-with-increment-operation/

//Using Arrays
class CustomStack {
    int maxsize = 0;
    int[] arr;
    int top = 0;
    public CustomStack(int ms) {
        this.maxsize = ms;
        arr = new int[maxsize];
    }
    
    public void push(int x) {
        if(top < maxsize)
        {
            arr[top] = x;
            top++;
        }
        return;
    }
    
    public int pop() {
        if(top == 0) return -1;
        int ele = arr[--top];
        return ele;
        
    }
    
    public void increment(int k, int val) {
        int min = Math.min(k, arr.length);
        for(int i = 0; i<min; i++)
        {
            arr[i] = arr[i]+val;
        }
    }
}



//Using Stack
class CustomStack {
    Stack<Integer> st = new Stack();
    int maxsize = 0;
    public CustomStack(int ms) {
        this.maxsize = ms;
    }
    
    public void push(int x) {
        if(maxsize!=st.size())   
        {
            st.push(x);
        }

        return;
    }
    
    public int pop() {
        if(st.isEmpty())
        {
            return -1;
        }
        
        return st.pop();
    }
    
    public void increment(int k, int val) {
        st = increment(st, st.size(), k, val);
    }
    
    public Stack<Integer> increment(Stack<Integer> st, int size, int k, int val)
    {
        if(st.size()==0) return st;
        
        int ele = st.pop();
        st = increment(st, st.size(), k, val);
        if(size<=k)
        {
            ele += val;
        }
        st.push(ele);
        return st;
    }
}

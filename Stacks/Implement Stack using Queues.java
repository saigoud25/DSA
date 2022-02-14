225. Implement Stack using Queues
https://leetcode.com/problems/implement-stack-using-queues/


/*
->Use Deque
->Add element at the starting of Queue
->remove first element from Queue 
*/
class MyStack {
    Deque<Integer> q;
    public MyStack() {
        q = new ArrayDeque();
    }
    
    public void push(int x) {
        q.addFirst(x);
    }
    
    public int pop() {
        return q.removeFirst();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(q.isEmpty())
        {
            return true;
        }
        return false;
    }
}

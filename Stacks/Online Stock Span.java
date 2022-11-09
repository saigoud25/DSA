901. Online Stock Span
https://leetcode.com/problems/online-stock-span/

/*
->Using Stack
->Search for last lowest value
*/
class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        
        while(!st.isEmpty() && st.peek()[0] <= price) {
            count += st.pop()[1];
        }
        
        st.push(new int[]{price, count});
        
        return count;
    }
}

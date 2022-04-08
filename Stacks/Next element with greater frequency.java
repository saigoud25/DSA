Next element with greater frequency
https://practice.geeksforgeeks.org/problems/9656e96f6eaee49e67400fa2aed7833c8d9846b8/1#

/*
->Next Greatest Element Approach, but using frequency
->If the Stack is empty, that element at ith position has no element with greater frequency
->If the frequncy of ith element is greater than frequency of top of stack element
    pop the top of the stack
->Else fill ans array with st.peek() and add ith element to the stack
*/
class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i : arr)
        {
            hm.put(i, hm.getOrDefault(i, 0)+1);
            
        }

        int i = n-1;
        while(i>=0)
        {
            ans[i] = -1;
            if(!st.isEmpty())
            {
                 while(!st.isEmpty())
                {
                    if(hm.get(arr[i])>=hm.get(st.peek()))
                    {
                        st.pop();
                    }
                    else
                    {
                        ans[i] = st.peek();
                        break;
                    }
                }
            }
            st.push(arr[i]);
            i--;
        }
        return ans;
    }
}

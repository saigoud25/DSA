The Celebrity Problem
https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1/#

/*
1. add the 0 to N-1 elements into stack
2. pop 2 elements, name them first and second
    if M[first][second]=1,i.e., first row contains the second ele, then push second to stack
    if M[first][second]=0,i.e, if it's 0, the first doesn't contains second,
        the first may the celebrity, so push it back to the stack
3. Now the stack contains the 1(ele) elements, we have to check whether it's a celebrity
4. if ele row contains any 1, then it is not a celebrity, return -1
5. other rows must contain 1 in, ele th position, i.e M[i][ele]==0, else return -1
6. return the element.
*/
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// 1
    	Stack<Integer> st = new Stack();
    	for(int i = 0; i<n; i++)
    	{
    	    st.add(i);
    	}
    	//2
    	for(int i = 0; i<n && st.size() >= 2; i++)
    	{
    	    int first = st.pop();
    	    int second = st.pop();
    	    if(M[first][second] == 1)
    	    {
    	        st.push(second);
    	    }
    	    else 
    	    {
    	        st.push(first);
    	    }
    	}
        //4&5
    	int val = st.pop();
        for(int i = 0; i<n; i++)
        {
            if(val==i) continue;
            if(M[val][i] == 1 || M[i][val] == 0) return -1;
        }
        
    	return val;
    }
}

84. Largest Rectangle in Histogram
https://leetcode.com/problems/largest-rectangle-in-histogram/
https://youtu.be/vcv3REtIvEo

/*
->Using Stack
https://youtu.be/vcv3REtIvEo

->Fill the left array, consists nearest left bar with heights<=heights[i], else 0
->Fill the right array, consits nearest right bar with heights<=heights[i], else n-1

->Find the all rectangle areas, (right[i]-left[i]+1)*heights[i]
->Find the max rectange area and return
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        left[0] = 0; st.push(0);
        for(int i = 1; i<n; i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                left[i] = 0;
            }
            else left[i] = st.peek()+1;
            st.push(i);
        }
        
        st = new Stack<>();
        right[0] = n-1; st.push(n-1);
        for(int i = n-1; i>=0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                right[i] = n-1;
            }
            else right[i] = st.peek()-1;
            st.push(i);
        }
        // System.out.println(Arrays.toString(right));
        
        for(int i = 0; i<n; i++)
        {
            int ele = (right[i]-left[i])+1;
            ele = ele*heights[i];
            max = Math.max(ele, max);
        }
        return max;
    }
}

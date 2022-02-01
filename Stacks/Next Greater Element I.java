496. Next Greater Element I
https://leetcode.com/problems/next-greater-element-i/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack();
        HashMap<Integer, Integer> hm = new HashMap();
        int[] arr = new int[nums1.length];
        //insert next greater element value in HashMap from right side of nums2
        // for(int i = nums2.length-1; i>=0; i--)
        // {
        //     int ele = nums2[i]; 
        //     if(st.isEmpty())
        //     {
        //         st.push(ele);
        //         hm.put(ele, -1);
        //         continue;
        //     }
        //     if(ele>st.peek())
        //     {   
        //         while(ele>st.peek())
        //         {
        //             st.pop();
        //             if(st.isEmpty()) break;
        //         }
        //         if(st.isEmpty())
        //         {
        //             hm.put(ele, -1);
        //             st.push(ele);
        //             continue;
        //         }
        //         else
        //         {
        //             hm.put(ele, st.peek());
        //             st.push(ele);
        //         }
        //     }
        //     else
        //     {
        //         hm.put(ele, st.peek());
        //         st.push(ele);
        //     }
        // }
        
        //Method 2
        for(int ele : nums2)
        {
            while(!st.isEmpty() && ele > st.peek())
            {
                hm.put(st.pop(), ele);
            }
            st.push(ele);
        }
        for(int i = 0; i<nums1.length; i++)
        {
            arr[i] = hm.getOrDefault(nums1[i], -1);
        }
        return arr;
    }
}

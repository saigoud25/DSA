/*
1011. Capacity To Ship Packages Within D Days
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

->Using Binary Search, Binary Search on answer method
->The search range will be max(array) and sum(array)
->Check for the mid(days) are possible or not
->If possible make high as mid-1, else low = mid+1
->Store the last possible day and return
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1, high = 0;
        
        for(int i : weights)
        {
            low = Math.max(low, i);
            high += i;
        }
        
        int w = high;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            boolean flag = isPossible(mid, weights, days);
            
            if(flag==true)
            {
                high = mid-1;
                w = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return w;
    }
    
    boolean isPossible(int mid, int[] arr, int t)
    {
        int sum = 0, count = 1;
        
        for(int i : arr)
        {
            if(sum+i > mid)
            {
                count++;
                sum = i;
            }
            else
            {
                sum += i;
            }
        }
        
        if(count <= t) return true;
        
        return false;
    }
}

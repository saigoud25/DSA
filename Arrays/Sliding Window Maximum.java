239. Sliding Window Maximum
https://leetcode.com/problems/sliding-window-maximum/

/*
->Method-1: Using Sliding Window + TreeMap 
->TreeMap is to find the max value in the k-size window

->Method-2: Using Deque
->Method-3: Divind into k-size slides and left_max_so_far and right_max_so_far array
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Method-1
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int pos = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i<k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);  
        }

        ans[pos++] = map.lastKey();
        
        for(int i = k; i<n; i++) {
            int freq = map.get(nums[i-k]);
            
            if(freq==1) {
                map.remove(nums[i-k]);
            } else {
                map.put(nums[i-k], freq-1); 
            }
            
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            
            ans[pos++] = map.lastKey();
        }
        
        return ans;
    }
}

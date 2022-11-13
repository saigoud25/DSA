2470. Number of Subarrays With LCM Equal to K
https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/

/*
->Finding the LCM of each sub array, by checking conditions
*/
class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0, n = nums.length; 
        
        for(int i = 0; i<n; i++) {
            if(k%nums[i] != 0 || nums[i] > k){
                continue;
            }
            
            int prev = nums[i];
            int temp = 0;
            
            if(prev==k) count++;
            
            for(int j = i+1; j<n; j++){
                temp = prev*nums[j]/gcd(prev, nums[j]);
                
                if(temp > k) {
                    break;
                }
                
                if(temp == k) {
                    count++;
                }
                
                prev = nums[j];
            }
        }
        
        return count;
    }
    
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}

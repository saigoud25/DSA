523. Continuous Subarray Sum
https://leetcode.com/problems/continuous-subarray-sum/

/*
->Using Prefix sum
->check the sum%k present in the map, if present the diff b/w it's index and i should be greater than 1
->Else put the sum%k as key and current index as value in tha HashMap
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        
        for(int i = 0; i<nums.length; i++) {
            sum = (sum + nums[i]) % k;

            if(map.containsKey(sum) && (i-map.get(sum)) > 1) {
                return true;
            }
            
            map.putIfAbsent(sum, i);
        }
        
        return false;
    }
}

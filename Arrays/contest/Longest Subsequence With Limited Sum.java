2389. Longest Subsequence With Limited Sum
https://leetcode.com/problems/longest-subsequence-with-limited-sum/

/*
->Sort the nums array
->Create TreeMap, which stores the prefix array as key and its index as value
->Iterate through queries and find the key, which is lessthan or equal key in the TreeMap
->Add the key's value in the ans array
*/
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);
        int[] ans = new int[queries.length];
        
        for(int i = 1; i<nums.length; i++) {
            nums[i] += nums[i-1];
            map.put(nums[i], i+1);
        }

        for(int i =0; i<queries.length; i++) {
            Integer k = map.floorKey(queries[i]);
            if(k != null) {
                ans[i] = (int)map.get(k);
            }
            else {
                ans[i] = 0;
            }
        }
        
        return ans;
    }
}

560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/
https://www.youtube.com/watch?v=20v8zSo2v18

/*
https://www.youtube.com/watch?v=20v8zSo2v18
Method-1:
->Maintain HashMap store the sum and it's frequency
->If sum-k found increment the count by (sum-k) frquency

Method-2:
->find Subarray using 2 for loops and maintain sum
->Increment count if sum==k
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        //Method-1
        HashMap<Integer, Integer> hm = new HashMap();
        int count = 0;
        int sum = 0;
        hm.put(0, 1);
        for(int i = 0; i<nums.length; i++)
        {
            sum += nums[i];
            if(hm.containsKey(sum-k))
            {
                count += hm.get(sum-k);
            }
            if(hm.containsKey(sum))
            {
                hm.put(sum, hm.get(sum)+1);
            }
            else
            {
                hm.put(sum, 1);
            }
        }
        return count;
        
        //Method-2
        // int count = 0;
        // for(int i = 0; i<nums.length; i++)
        // {
        //     int sum = 0;
        //     for(int j = i; j<nums.length; j++)
        //     {
        //         sum += nums[j];
        //         if(sum == k) count++;
        //     }
        // }
        // return count;
    }
}

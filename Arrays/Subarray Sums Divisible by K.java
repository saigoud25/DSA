974. Subarray Sums Divisible by K
https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/
https://youtu.be/QM0klnvTQzk


/*
https://youtu.be/QM0klnvTQzk
->Maintain prefix sum
->Put, Remainder of sum%k in HashMap
    ->If remainder already present, add that frequency to count and increment remainder frequency
    ->Else put, remainder and It's frequncy as 1
    ->If remainder is an Negative number add k to it
*/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum = 0;
        for(int i : nums)
        {
            sum += i;
            int ele = sum%k;
            if(ele<0)
            {
                ele += k;
            }
            if(hm.containsKey(ele))
            {
                count += hm.get(ele);
                hm.put(ele, hm.get(ele)+1);
            }
            else
            {
                hm.put(ele, 1);
            }
        }
        return count;
    }
}

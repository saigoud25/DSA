2261. K Divisible Elements Subarrays
https://leetcode.com/problems/k-divisible-elements-subarrays/

/*
->Using HashSet
->Add all the subarrays into the HashSet,
->While creating subsets, if the jth element is divisible by p, increment temp
->If temp is greater than k, break that loop
->Return the size of the final HashSet
*/
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i<nums.length; i++)
        {
            int temp = 0;
            StringBuilder s = new StringBuilder();
            for(int j = i; j<nums.length; j++)
            {
                
                if(nums[j]%p==0) 
                {
                    temp++;
                }
                if(temp>k) 
                {
                    break;
                }
                
                s.append(nums[j]+" ");
                set.add(s.toString());
            }
        }
        // System.out.println(set);
        return set.size();
    }
}

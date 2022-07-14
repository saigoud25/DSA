90. Subsets II
https://leetcode.com/problems/subsets-ii/
https://youtu.be/RIn3gOkbhQE

/*
https://youtu.be/RIn3gOkbhQE
*/
class Solution {
    List<List<Integer>> arr;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        arr = new ArrayList<>();
        Arrays.sort(nums);
  
        helper(0, nums, new ArrayList<>());
        return arr;
    }
    
    void helper(int ind, int[] nums, List<Integer> list)
    {
        arr.add(new ArrayList<>(list));
        
        for(int i = ind; i<nums.length; i++)
        {
            if(i != ind && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            helper(i+1, nums, list);
            list.remove(list.size()-1);
        }
    }
} 

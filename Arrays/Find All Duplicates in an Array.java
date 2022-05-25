442. Find All Duplicates in an Array
https://leetcode.com/problems/find-all-duplicates-in-an-array/

/*
->Using Cyclic Sort Method, sorts array of 1-n numbers
->Add the elements into the list which are not in it's position

->Method-2
->Making visited elements as -1, if -1 appears i.e., it's a duplicate element
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(i<nums.length)
        {
            if(nums[i]==nums[nums[i]-1]) i++;
            else if(i+1==nums[i]) i++;
            else
            {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
        i = 0;
        for(i = 0; i<nums.length; i++)
        {
            if(i+1 != nums[i]) list.add(nums[i]);
        }
        
        return list;
    }
}

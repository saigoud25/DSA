2295. Replace Elements in an Array
https://leetcode.com/problems/replace-elements-in-an-array/

/*
->Using HashMaps
->Map nums value to it's index
->>Replace the operations[0] with operations[1] in the nums[index(operation[0])] 
*/
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++)
        {
            map.put(nums[i], i);
        }
        
        for(int[] i : operations)
        {
            nums[map.get(i[0])] = i[1];
            
            map.put(i[1], map.get(i[0]));
            map.remove(i[0]);
        }
        
        return nums;
    }
}

1296. Divide Array in Sets of K Consecutive Numbers
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k != 0) return false;
        if(k == 1) return true;
        
// Using TreeMap takes O(logn) to retrive elements in sorted order;
        
//         TreeMap<Integer, Integer> hm = new TreeMap();
//         for(int i = 0; i<nums.length; i++)
//         {
//             hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
//         }

//         for(Integer i : hm.keySet())
//         {
//             if(hm.get(i)>0)
//             {
//                 for(int j = k-1; j>=0; j--)
//                 {
//                     if(hm.getOrDefault(i+j, 0)<hm.get(i)) return false;
//                     hm.put(i+j, hm.get(i+j)-hm.get(i));
//                 }
//             }
//         }
        
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0; i<nums.length; i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<Integer> arr = new ArrayList(hm.keySet());
        Collections.sort(arr);
        
        for(Integer i : arr)
        {
            if(hm.get(i)>0)
            {
                for(int j = k-1; j>=0; j--)
                {
                    if(hm.getOrDefault(i+j, 0)<hm.get(i)) return false;
                    hm.put(i+j, hm.get(i+j)-hm.get(i));
                }
            }
        }
        
        return true;
    }
}

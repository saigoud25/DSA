347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        
        HashMap<Integer, Integer> hm = new HashMap();
        int[] arr = new int[k];
        
        for(int i = 0; i<nums.length; i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<Integer> temp = new ArrayList(hm.values());
        Collections.sort(temp, Collections.reverseOrder());
        
        for(int i = 0; i<k; i++)
        {
            int ele = temp.get(i);
            
            for(Integer in : hm.keySet())
            {
                if(hm.get(in) == ele)
                {
                    arr[i] = in;
                    hm.remove(in);
                    break;
                }   
            }
        }
            
        return arr;
    }
}

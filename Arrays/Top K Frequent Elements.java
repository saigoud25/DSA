347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/


/*
->First create the HashMap1 with elements keys and their frequency as values
->Convert that HashMap1 as HashMap2, hm1 keys as hm2 values and hm1 values as hm2 keys,
    ->Use ArraysList as values of hm2
->Add keyset of hm2 into PriorityQueue (Max Heap)
->pq contains the highest frequency of elements
->remove the element from pq and get the values of that element from hm2(ArrayList)
->return array if array length is equal to k
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;

        HashMap<Integer, Integer> hm = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, ArrayList<Integer>> val = new HashMap<>();
            
        int[] arr = new int[k];
        
        for(int i = 0; i<nums.length; i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }     
        
        for(Map.Entry<Integer, Integer> e : hm.entrySet())
        {
            int key = e.getKey();
            int v = e.getValue();
            
            if(!val.containsKey(v))
            {
                val.put(v, new ArrayList<Integer>());
            }
            val.get(v).add(key);
        }
        pq.addAll(val.keySet());
        int pos = 0;
        
        while(pos<k)
        {
            for(int i : val.get(pq.poll()))
            {
                arr[pos++] = i;
                if(pos==k) return arr;
            }
        }   
        return arr;
    }
}


//Bruteforce
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

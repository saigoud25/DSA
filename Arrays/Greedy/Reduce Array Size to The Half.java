1338. Reduce Array Size to The Half
https://leetcode.com/problems/reduce-array-size-to-the-half/

class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //Hashmap to find the frequency 
        for(int i = 0; i<arr.length; i++)
        {   
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        
        //Inserting frequencies in the list and sort by decreasing order 
        ArrayList<Integer> list = new ArrayList(hm.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        for(int i = 0; i<list.size(); i++)
        {
            sum += list.get(i);
            if(sum>=(arr.length/2)) return i+1;
        }
        
        return arr.length/2;
    }
}

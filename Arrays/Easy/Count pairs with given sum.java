Count pairs with given sum
https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1/

/*
->Create a HashMap arr[i] as a key and it's frequency as a value,
->If k-arr[i], contains in the map, it forms a pair, so add the frequncy to the sum
*/
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i : arr)
        {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int i : arr)
        {
            if(map.containsKey(k-i))
            {
                int ele = map.get(k-i);
                if(i==(k-i)) ele--;
                
                sum += ele;
                
                map.put(i, map.get(i)-1);
                
                if(map.get(i)==0) map.remove(i);
            }
        }
        
        return sum;
    }
}

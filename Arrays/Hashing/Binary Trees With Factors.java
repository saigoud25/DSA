823. Binary Trees With Factors
https://leetcode.com/problems/binary-trees-with-factors/

/*
->HashMap contains arr elements as keys and number of binary tree factors as values
->Sort the Array,
->Traverse from the left, check whether the element have factors
->If there are factors multiply the values of factors and put the value into the map
*/
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Long> map = new HashMap<>();
        Arrays.sort(arr);
        long ans = 0;
        int mod = 1000000007;
        map.put(arr[0], 1l);
        for(int i = 0; i<arr.length; i++) {
            int ele = arr[i];
            long temp = 1l;
            
            for(int j = 0; j<i; j++) {
                int k = arr[j];
                
                if(ele%k==0 && map.containsKey(ele/k)) {
                    temp += map.get(k)*map.get(ele/k) % mod;
                }
                
            }
            ans = (ans + temp) % mod;
            map.put(ele, temp);
        }
        // System.out.println(map);
        return (int)ans;
    }
}

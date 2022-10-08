2150. Find All Lonely Numbers in the Array
https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/

/*
->Using a HashMap store the frequency, 
->If the elements frequency is 1 and element+1 and element-1 are absent in tha map, add element tnto res array
*/
class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int i : nums) {
            if(map.get(i)==1 && !map.containsKey(i-1) && !map.containsKey(i+1)) {
                res.add(i);
            }
        }
        
        return res;
    }
}

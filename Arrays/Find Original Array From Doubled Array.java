2007. Find Original Array From Doubled Array
https://leetcode.com/problems/find-original-array-from-doubled-array/

/*
->Sort the Array
->Insert all Array values into HashMap,
->Traverse from starting of Array, remove all the doubles of i and add the i to the array
*/
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 != 0) return new int[0];
        
        Arrays.sort(changed);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : changed) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        int[] temp = new int[changed.length/2];
        int pos = 0, prev = -1;

        for(int i : changed) {
            if(i==prev) continue;
            if(map.get(i) > map.getOrDefault(i+i, 0)) {
                return new int[0];
            }
            
            for(int k = 0; k < map.get(i); k++) {
                temp[pos++] = i;
                map.put(i+i, map.get(i+i)-1);
            }
            
            prev = i;
        }
        
        return temp;
    }
}

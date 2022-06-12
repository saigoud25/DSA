2300. Successful Pairs of Spells and Potions
https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

/*
->Sort the Potions array, search for the first successful pair
*/
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        TreeMap<Long, Integer> tm = new TreeMap<>();
        tm.put(Long.MAX_VALUE, n);
        
        for(int i = n-1 ; i>=0; i--) tm.put((long)potions[i], i);

        
        for(int i = 0; i<spells.length; i++)
        {
            long ele = (success+spells[i]-1)/spells[i];
            
            spells[i] = n - (int)tm.ceilingEntry(ele).getValue();
        }
        
        return spells;
    }
    
    
}

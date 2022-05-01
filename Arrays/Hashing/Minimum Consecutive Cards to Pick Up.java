2260. Minimum Consecutive Cards to Pick Up
https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/


/*
->Using HashMap
->Store the element as a key and it's index as a value in HashMap
->if the key repeats which means it is a matching card, store the length
->Current index+1 - previous index = length
->Update the min, if for every match card found
->Update the last found index of the card in HashMap
*/
class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<cards.length; i++)
        {
            if(map.containsKey(cards[i]))
            {
                int num = (i+1)-map.get(cards[i]);
                min = Math.min(num, min);
            }
            map.put(cards[i], i);
           
        }
        
        if(min==Integer.MAX_VALUE) return -1;
        
        return min;
    }
}

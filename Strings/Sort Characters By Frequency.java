451. Sort Characters By Frequency
https://leetcode.com/problems/sort-characters-by-frequency/


/*
->Using PriorityQueue and HashMap to count frequency
->PriorityQueue will be sorted based on the Frequency using Comparator
->Now poll the elements from pq and append to the sb (map.get(ch)) times
*/
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+1);
        
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Character a, Character b)
            {
                return map.get(b)-map.get(a);
            }
        });
        
        for(Character ch : map.keySet())
        {
            pq.add(ch);
        }
        
        while(!pq.isEmpty())
        {
            char ch = pq.poll();
            
            for(int i = map.get(ch); i>0; i--)
            {
                sb.append(ch);
            }
            
            map.remove(ch);
        }
        
        return sb.toString();
    }
}

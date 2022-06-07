767. Reorganize String
https://leetcode.com/problems/reorganize-string/

/*
->Create a HashMap of frequency of Characters
->Create a PriorityQueue based on the frequency of Characters in a HashMap
->Elements from the PriorityQueue will be removed based on the High Priority
->Poll last two elements from the pq and append both to the sb, decrement their frequency in the HashMap
->If the Frequency is greater than 0, again add polled element to the pq
->Check if the elements left the pq, if the left character frequency is greater than 1, return empty string
->Else append last element to the sb
*/
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<>()
          {
              @Override
              public int compare(Character a, Character b)
              {
                  return map.get(b)-map.get(a);
              }
              
          });
        
        pq.addAll(map.keySet());
        
        while(pq.size()>1)
        {
            char curr = pq.poll();
            char next = pq.poll();
            
            sb.append(curr);
            sb.append(next);
            
            map.put(curr, map.get(curr)-1);
            map.put(next, map.get(next)-1);
            
            if(map.get(curr)>0)
            {
                pq.add(curr);
            }
            if(map.get(next)>0)
            {
                pq.add(next);
            }
        }
        
        if(pq.size()>0)
        {
            char last = pq.poll();
            if(map.get(last)>1) return "";
            sb.append(last);
        }
        return sb.toString();
    }
}

30. Substring with Concatenation of All Words
https://leetcode.com/problems/substring-with-concatenation-of-all-words/

/*
->If the first word is in map, then check for other words
    ->If all words exists then add the starting index to list
*/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String i : words) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        int i = 0;
        int n = s.length(), wl = words[0].length(), totalLength = wl*words.length;
        while(i<=(n-totalLength)) {
            int count = 0;
            HashMap<String, Integer> temp = new HashMap<>(map);
            String word = s.substring(i, i+wl);
            if(map.containsKey(word)) {
                String t = s.substring(i, i+totalLength);
                
                int k = 0;
                while(k<totalLength) {
                    String w = t.substring(k, k+wl);
                    if(temp.containsKey(w)) {
                        count++;
                        int val = temp.get(w);
                        if(val==1) {
                            temp.remove(w);
                        }
                        else {
                            temp.put(w, val-1);
                        }
                        
                    }
                    else {
                        break;
                    }
                    k += wl;
                }
                if(count==words.length && temp.size()==0) {
                    list.add(i);
                }
            }
   
            count = 0;
            i++;
        }
        
        return list;
    }
}

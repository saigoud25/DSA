692. Top K Frequent Words
https://leetcode.com/problems/top-k-frequent-words/

/*
->Create an HashMap to store String and it's frequencies
->The Comparator return the the String which have high frequency, 
    ->If the frequencies of both strings are equal, it compare both strings and return the 
        string which is lexicographically smaller
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                if(map.get(a)==map.get(b)) {
                    return a.compareTo(b);
                }
                
                return map.get(b)-map.get(a);
            }
        });
        
        for(String s : words) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        pq.addAll(map.keySet());
        
        for(int i = 0; i<k; i++) {
            res.add(pq.poll());
        }
        
        return res;
    }
}

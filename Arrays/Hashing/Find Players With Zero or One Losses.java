2225. Find Players With Zero or One Losses
https://leetcode.com/problems/find-players-with-zero-or-one-losses/

/*
-> Create a HashMap which stores the frequency of losers
-> By using map, find the the players who not lost any match and players who lost exactly one match 
*/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> oneMatch = new TreeSet<>();
        TreeSet<Integer> notLost = new TreeSet<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for(int[] i : matches) {
            map.put(i[1], map.getOrDefault(i[1], 0)+1);
        }
                
        for(Integer i : map.keySet()) {
            if(map.get(i) == 1) {
                oneMatch.add(i);
            }
        }
        
        for(int[] i : matches) {
            if(!map.containsKey(i[0])) {
                notLost.add(i[0]);
            }
        }
        
        res.add(new ArrayList<>(notLost));
        res.add(new ArrayList<>(oneMatch));
        
        return res;
    }
}

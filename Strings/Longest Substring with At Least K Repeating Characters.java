395. Longest Substring with At Least K Repeating Characters
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters


/*
Method-1
https://youtu.be/5QpMpO2CAb0
->Using Divide and Conquer Method

Method-2
->By maintaining a map and set, if the count, which is number of characters greater than k are equal to the map.size(), update the max variable
*/
class Solution {
    public int longestSubstring(String s, int k) {
        //Method-2
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int count = 0, max = 0;
        
        for(int i = 0; i<s.length(); i++) {
            for(int j = i; j<s.length(); j++) {
                char ch = s.charAt(j);
                int f = map.getOrDefault(ch, 0)+1;
                map.put(ch, f);
                
                if(f>=k && !set.contains(ch)) {
                    count++;
                    set.add(ch);
                }
                
                if(map.size()==count) {
                    max = Math.max(max, (j-i)+1);
                }
            }
            set.clear();
            map.clear();
            count = 0;
        }
        
        return max;
    }
}

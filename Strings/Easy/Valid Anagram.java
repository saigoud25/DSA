242. Valid Anagram
https://leetcode.com/problems/valid-anagram/

/*
->Using HashMap
->Increase the frequency of characters of s string
->Decrease the frequency of characters of t string
->Iterate through values of HashMap, if any value is non zero return false, else return true
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int s1 = s.length();
        int t1 = t.length();
        
        if(s1 != t1) return false;
        
        for(int i = 0; i<s1; i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }
        
        for(Character ch : map.keySet()) 
        {
            if(map.get(ch) != 0) return false;
        }
        return true;
    }
}

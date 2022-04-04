3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
https://youtu.be/qtVh-XEpsJo


/*
https://youtu.be/qtVh-XEpsJo
->Using HashMap to maintain last occurance of character
->If the character present in the hashmap and it's occurance position is greater than the last_position, update the last_position
->Else simply add character along with position in the HashMap
->length = right-left+1
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int length = 1, lp = 0; 
        
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(hm.containsKey(ch) && hm.get(ch)>=lp)
            {
                lp = hm.get(ch)+1;                
            }
            hm.put(ch, i);
            length = Math.max(i-lp+1, length);
        }
        return length;
    }
}

2131. Longest Palindrome by Concatenating Two Letter Words
https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/

/*
->Put the reverse string to the HashMap
->If the HashMap contains the word, add +4 to the count, and remove the word from the map
->If the HashMap contains word with similar characters, add +2 to the count and break
*/
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        
        for(String word : words)
        {

            if(map.containsKey(word))
            {
                count += 4;
                
                map.put(word, map.getOrDefault(word, 0)-1);
                
                if(map.get(word)==0)
                {
                    map.remove(word);
                }
            }
            else 
            {
                map.put(""+word.charAt(1)+word.charAt(0), map.getOrDefault(""+word.charAt(1)+word.charAt(0), 0)+1);
            }
        }
        
        for(String word : map.keySet())
        {
            if(word.charAt(0)==word.charAt(1))
            {
                count += 2;
                break;
            }
        }
        return count;
    }
}

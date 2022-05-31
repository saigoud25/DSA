2287. Rearrange Characters to Make Target String
https://leetcode.com/problems/rearrange-characters-to-make-target-string/

/*
->Find the Frequency of two Strings in two hashmaps
->The answer will be min of floor(x occurence in s/y occurence in target)
*/
class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(char ch : s.toCharArray())
        {
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        for(char ch : target.toCharArray())
        {
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(char ch : map2.keySet())
        {
            if(map1.get(ch)==null) return 0;
            int temp = (int)Math.floor(map1.get(ch)/map2.get(ch));
            min = Math.min(temp, min);
        }
        
        return min;
    }
}

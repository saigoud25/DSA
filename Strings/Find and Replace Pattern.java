890. Find and Replace Pattern
https://leetcode.com/problems/find-and-replace-pattern/


/*
->Create a HashMap, check pattern character with word character,
->If don't contains pattern character, simply add the f->s
->S should be be pointed by only one character in the pattern
*/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int n = pattern.length();
        for(String word : words) {
            boolean flag = true;
            for(int i = 0; i<n; i++) {
                char f = pattern.charAt(i);
                char s = word.charAt(i);
                
                if(map.containsKey(f)) {
                    if(map.get(f)==s) continue;
                    flag = false;
                    break;
                }
                if(set.contains(s)) {
                    flag = false;
                    break;
                }
                
                map.put(f, s);
                set.add(s);
            }
            
            if(flag) list.add(word);
            map.clear();
            set.clear();
        }
        
        return list;
    }
}

916. Word Subsets
https://leetcode.com/problems/word-subsets/

/*
->Using Max Freq Count Method
->First Traverse through words2 array, for each string make the frequency array
    ->Update this frequency array of each string with general max frequency array
    ->(General max freq array consists max frequency of that character)
->Now Traverse through the words1 array, for each string make the frequency array
    ->Check this temp freq array with general max freq array, if the freq of temo array is less than general array, it means the string is not a universal string 

*/
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] a = new int[26];
        
        for(String s : words2) {
            int[] t = new int[26]; 
            for(char ch : s.toCharArray()) {
                t[ch-'a']++;
            }
            
            for(int i = 0; i<26; i++) {
                a[i] = Math.max(t[i], a[i]);
            }

        }
        // System.out.println(map);
        for(String s : words1) {
            int[] t = new int[26]; 
            for(char ch : s.toCharArray()) {
                t[ch-'a']++;
            }
            boolean flag = true;

            for(int i = 0; i<26; i++) {
                if(a[i]>t[i]) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) ans.add(s);
        }
        
        return ans;
    }
}

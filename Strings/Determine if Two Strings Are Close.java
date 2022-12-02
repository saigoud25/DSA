1657. Determine if Two Strings Are Close
https://leetcode.com/problems/determine-if-two-strings-are-close/

/*
->Find the frequencies of both strings 
->Return false if one frequency is 0 and another is not null
->Sort the two frequency Arrays
->Check whether both sorted strings are equal or not
*/
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = 26;
        if(word1.length() != word2.length()) {
            return false;
        }
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(char ch : word1.toCharArray()) {
            freq1[ch-'a']++;
        }
        
        for(char ch : word2.toCharArray()) {
            freq2[ch-'a']++;
        }
        
        for(int i = 0; i < n; i++) {
            if(freq1[i] == freq2[i]) {
                continue;
            }
            if(freq1[i]==0 || freq2[i]==0) {
                return false;
            }
        }
        
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        
        for(int i = 0; i < n; i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }
        
        return true;
    }
}

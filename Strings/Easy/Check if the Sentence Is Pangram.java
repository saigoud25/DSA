1832. Check if the Sentence Is Pangram
https://leetcode.com/problems/check-if-the-sentence-is-pangram/

/*
->Create a array to store the frequency of a characters in a sentece
->If any of the character's frequency is 0, return false
*/
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        
        for(char ch : sentence.toCharArray()) {
            arr[ch-'a']++;
        }
        
        for(int i : arr) {
            if(i==0) {
                return false;
            }
        }
        
        return true;
    }
}

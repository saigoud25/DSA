804. Unique Morse Code Words
https://leetcode.com/problems/unique-morse-code-words/

/*
-> Using Set
-> Create the array of Morse Code words
-> Create the Strings using arra and store in Set
*/
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String s : words) {
            StringBuilder sb = new StringBuilder();
            for(char ch : s.toCharArray()) {
                sb.append(arr[ch-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}

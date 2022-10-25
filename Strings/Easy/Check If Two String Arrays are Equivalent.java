1662. Check If Two String Arrays are Equivalent
https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

/*
->Uisng 4 pointers, 
->2 for iterating Arrays
->2 for iterating inside Strings
*/

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int a = 0, b = 0;
        
        while(i<word1.length && j<word2.length) {
            if(word1[i].charAt(a++) != word2[j].charAt(b++)) {
                return false;
            }
            
            if(a == word1[i].length()) {
                i++;
                a = 0;
            }
            
            if(b == word2[j].length()) {
                j++;
                b = 0;
            }
        }
        
        if(a==0 && b==0 && i==word1.length && j==word2.length) {
            return true;
        }
        
        return false;
    }
}

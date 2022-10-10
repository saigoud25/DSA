1328. Break a Palindrome
https://leetcode.com/problems/break-a-palindrome/

/*
->Iterate upto half of the string, if there is non-'a' character replace it with 'a' and return
->If the string contains all 'a', then append 'b' at the end and return
*/

class Solution {
    public String breakPalindrome(String s) {
        int n = s.length();
        if(n == 1) return "";
                
        for(int i = 0; i<n/2; i++) {
            if(s.charAt(i) != 'a') {
                return s.substring(0, i)+ 'a' +s.substring(i+1);
            }
        }
        
        return s.substring(0, s.length()-1) + 'b';
    }
}

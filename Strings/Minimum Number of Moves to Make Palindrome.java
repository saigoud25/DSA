2193. Minimum Number of Moves to Make Palindrome
https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/

/*
->Find the first index, of last character of a string
->If the index is equal to n-1, i.e., it's a odd string, that character should be move to middle
which is i/2 moves
->Else, the character should move index number times to make it palindrome
*/
class Solution {
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        if(n<=2) return 0;

        int i = s.indexOf(s.charAt(n-1));
        
        if(i==n-1) {
            return (i/2) + minMovesToMakePalindrome(s.substring(0, n-1));
        }
        
        return i + minMovesToMakePalindrome(s.substring(0, i)+s.substring(i+1, n-1));
    }
}

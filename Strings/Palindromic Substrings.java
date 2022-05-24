647. Palindromic Substrings
https://leetcode.com/problems/palindromic-substrings/
https://youtu.be/4RACzI5-du8

/*
https://youtu.be/4RACzI5-du8
->For odd lengths take each index as center and find all Palindromic Substrings from that index
    ->Decrement left pointer and increment right pointer 
->For Even lengths take i as left and i+1 index as right
*/

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for(int i = 0; i<s.length(); i++)
        {
            //For Odd Length(i, i) & For Even Length(i, i+1)
            int left = i, right = i;
            count += helper(i, i, s) + helper(i, i+1, s);
        }
        
        return count;
    }
    
    int helper(int left, int right, String s)
    {
        int count = 0;
        
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
        
        return count;
    }
}

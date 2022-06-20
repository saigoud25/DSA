2311. Longest Binary Subsequence Less Than or Equal to K
https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/
https://youtu.be/_Mitj9TfHk0


/*
https://youtu.be/_Mitj9TfHk0

->Count all the zero's in the string
->Iterate the string from the backside
->If '1' found, find the digit value at that place and add to the sum and increment the len
->If sum > k return the len
->
*/
class Solution {
    public int longestSubsequence(String s, int k) {
        int sum = 0;
        int len = 0;
        
        for(char ch : s.toCharArray())
        {
            if(ch=='0') len++;
        }
        
        for(int i = s.length()-1; i>=0; i--)
        {
            char ch = s.charAt(i);
            if(ch=='1')
            {
                sum += Math.pow(2, s.length()-1-i);
                if(sum>k)
                {
                    return len;
                }
                
                len++;
            }
        }
        
        return len;
    }
}

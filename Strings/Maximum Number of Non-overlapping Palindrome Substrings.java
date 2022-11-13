2472. Maximum Number of Non-overlapping Palindrome Substrings
https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/

/*
->Finding Palindrome by appending '*' in middle of every character
->If the Palindrome length reaches k, 
    ->increment the count, 
    ->take it's right as left boundary point for next palindrome
    ->break the inside loop
*/
class Solution {
    public int maxPalindromes(String s, int k) {
        if(k==1) {
            return s.length();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        
        for(int i = 1; i<s.length(); i++) {
            sb.append("*"+s.charAt(i));
        }
        
        int count = 0;
        int prev = -1;
        
        char[] arr = sb.toString().toCharArray();
        int n = arr.length;
        
        for(int i = 0; i<n; i++) {
            int left = i-1, right = i+1;
            int currLen = 0;
            
            if(arr[i] != '*') {
                currLen++;
            }
            
            while(prev < left && left>=0 && right<n) {
                if(arr[left] == arr[right]) {
                    if(arr[left] != '*') {
                        currLen += 2;
                    }
                    if(currLen >= k) {
                        prev = right;
                        i = prev-1;
                        count++;
                        break;
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
                
            }
        }
        
        return count;
    }
}

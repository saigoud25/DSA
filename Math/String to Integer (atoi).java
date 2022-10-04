8. String to Integer (atoi)
https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String s) {
        int i = 0, ans = 0;
        boolean isNegative = false;
        
        //Remove Leading whitespaces
        while(i<s.length() && s.charAt(i)==' ') {
            i++;
        }
        
        if(i==s.length()) return 0;
        
        //Checking positive/negative
        if(s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if(s.charAt(i) == '+') {
            i++;
        }
        
        //Converting string to int upto non-integer occurs
        while(i<s.length() && Character.isDigit(s.charAt(i))) {
            int digit = (int) s.charAt(i)-'0';
            
            //If ans exceeds Integer range return Min/Max value
            if(ans > ((Integer.MAX_VALUE - digit) / 10)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            ans = (ans*10) + digit;
            i++;
        }
                
        return (int) (isNegative ? -ans : ans);
    }
}

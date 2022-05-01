844. Backspace String Compare
https://leetcode.com/problems/backspace-string-compare/

/*
->First work on String s,
    ->If character is not '#', append it to StringBuilder
    ->If it is '#' remove last character from the StringBuilder
->Do same to the String t, and compare both new Strings
*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        int i = s.length()-1, h1 = 0;

        return helper(s).equals(helper(t));
    }
    String helper(String s)
    {
        int i = 0;
        StringBuilder temp = new StringBuilder();
        while(i<s.length())
        {
            if(s.charAt(i) != '#')
            {
                temp.append(s.charAt(i));
            }
            else
            {
                if(temp.length() != 0)
                {
                    temp.deleteCharAt(temp.length()-1);
                }
            }
            i++;
        }
        
        return temp.toString();
    }
}

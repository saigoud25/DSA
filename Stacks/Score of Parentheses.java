856. Score of Parentheses
https://leetcode.com/problems/score-of-parentheses/submissions/

/*
->Traverse the string, If '(' found increment balance
->If ')' found decrement balance
    ->If s.charAt(i-1)=='(' , add 1<<balance to ans
*/
class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, balance = 0;
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i)=='(')
            {
                balance++;
            }
            else
            {
                balance--;
                if(s.charAt(i-1)=='(')
                {
                    ans += 1<<balance;
                }
            }
        }
        return ans;
    }
}

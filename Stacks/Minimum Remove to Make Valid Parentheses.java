1249. Minimum Remove to Make Valid Parentheses
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

/*
->If '(' occured add the position into stack
->If ')' occured
    ->If stack is not empty remove the position element from stack 
    ->If stack empty, set that position to "*"
->After traversing, If stack is not empty, set all positions in stack to "*"
->Remove all "*" and return string
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuffer str = new StringBuffer(s);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<s.length(); i++)
        {
            if(str.charAt(i)=='(')
            {
                st.add(i);
            }
            if(str.charAt(i)==')')
            {
                if(!st.isEmpty()) st.pop();
                else{
                    str.setCharAt(i, '*');
                }
            }
        }
        
        while(!st.empty())
        {
            str.setCharAt(st.pop(), '*');
        }
        
        return str.toString().replaceAll("\\*", "");
    }
}

20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/

/*
->Push a character into a stack if it's empty
->If Left parantheses found
    ->If stack.peek() is Right paranatheses of that character pop an element
->Else if it's a Right parantheses simply push into stack
->After iteration if the stack is empty return true, else false
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++)
        {
            if(st.isEmpty())
            {
                st.push(s.charAt(i));
                continue;
            }
            
            if(s.charAt(i)=='}' && st.peek()=='{') 
            {
                st.pop();
            }
            else if(s.charAt(i)==')' && st.peek()=='(') 
            {
                st.pop();
            }
            else if(s.charAt(i)==']' && st.peek()=='[') 
            {
                st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
            
        }
        if(st.size()>0) return false;
        
        return true;
    }
}

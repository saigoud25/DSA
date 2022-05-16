150. Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/

/*
->Using Stack 
->Add the elements into stack if the given string is number
->Else perform arithmetic operations on top two integers in sack, and add result
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String i : tokens)
        {
            if(48<=i.charAt(i.length()-1) && i.charAt(i.length()-1)<=57)
            {
                st.push(Integer.parseInt(i));
            }
            else
            {
                int first = st.pop();
                int sec = st.pop();
                if(i.equals("+"))
                {
                    first += sec;
                }
                else if(i.equals("-"))
                {
                    first = sec-first;
                }
                else if(i.equals("*"))
                {
                    first *= sec;
                }
                else
                {
                    first = sec/first;
                }
                
                st.push(first);
            }
        }
        
        return st.peek();
    }
}

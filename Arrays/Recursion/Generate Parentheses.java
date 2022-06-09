22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/

/*
->Using recursion
->similar to pick & not pick, here choices are, pick "(" or pick ")"
->If the  close parentheses ")" value is less than the open, simply return
->If open parentheses value is 0,
    ->If close value is greater than 0, append ")" close value times to the string
    ->Add the String "s" to the list
*/
class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<String>();

        helper("(", n-1, n);
        
        return list;
    }
    
    void helper(String s, int open, int close)
    {
        if(close==0 || close<open)
        {
            return;
        }

        if(open==0)
        {
            while(close-- > 0)
            {
                s += ")";
            }
            list.add(s);
            return;
        }
        
        helper(s+"(", open-1, close);

        helper(s+")", open, close-1);
      
        return ;
    }
}

71. Simplify Path
https://leetcode.com/problems/simplify-path/

/*
->Using Stack and Splitting the path into array by regular expression "/"
->Traverse through array,
    ->If element is ".." pop an element from stack
    ->If element is 0 length pass
    ->If element length is not 0 & element is not "." push ("/"+element) into stack
->If stack is empty return "/"
->Traverse through stack pop and add elements into starting of a return string
*/
class Solution {
    public String simplifyPath(String path) {
        String str = "";
        Stack<String> st = new Stack<>();
        
        for(String s : path.split("/"))
        {
            if(s.equals(".."))
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
            }
            else
            {
                if(!s.isEmpty() && !s.equals("."))
                {
                    st.push("/"+s);
                }
            }
        }
        
        if(st.isEmpty()) return "/";
        while(!st.isEmpty())
        {
            str = st.pop()+str;
        }
        return str;
    }
}

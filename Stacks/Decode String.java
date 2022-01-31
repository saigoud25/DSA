394. Decode String
https://leetcode.com/problems/decode-string/

class Solution {
    public String decodeString(String s) {
        String str = "";
        String numStr = "";
        Stack<Integer> countStack = new Stack();
        Stack<String> resStack = new Stack();
        int ind = 0;
        
        while(ind<s.length())
        {
            char ch = s.charAt(ind);
            if(Character.isDigit(ch))
            {
                while(s.charAt(ind) != '[')
                {
                    numStr += s.charAt(ind);
                    ind++;
                }
                countStack.push(Integer.valueOf(numStr));
                numStr = "";
            }
            else if(ch == '[')
            {
                resStack.push(str);
                str = "";
                ind++;
            }
            else if(ch == ']')
            {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int count = countStack.pop();
                for(int i = 0; i<count; i++)
                {
                    temp.append(str);
                }
                str = temp.toString();
                ind++;
            }
            else
            {
                str += ch;
                ind++;
            }
        }
        return str;
    }
}

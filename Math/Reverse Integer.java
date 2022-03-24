7. Reverse Integer
https://leetcode.com/problems/reverse-integer/

/*
->Converted the number to String
->Reverse the string using StringBuilder and Convert that String into long 
->If Converstion is not possible return 0
->Check If the number is negative, multiply the number by -1
*/
class Solution {
    public int reverse(int x) {
        String s = ""+x;
        char ch = x<0?'-': '0';
        StringBuilder st;
        if(ch=='-')
        {
            st = new StringBuilder(s.substring(1));
        }
        else
        {
            st = new StringBuilder(s);
        }
        String s2 = st.reverse().toString();
        try
        {
            long num = Integer.parseInt(s2);
        
            // if(num>Integer.MAX_VALUE || num<=Integer.MIN_VALUE) return 0;
            if(ch=='-') num *= -1;
            return (int)num;
        }
        catch(Exception e)
        {
            return 0;
        }
        
    }
}

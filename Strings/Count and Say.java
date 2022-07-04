38. Count and Say
https://leetcode.com/problems/count-and-say/

/*
->Just iterate the loop n times, each time simply count the string and update string with new counted string
*/
class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i<n; i++)
        {
            StringBuilder sb = new StringBuilder();
            
            char prev = s.charAt(0);
            int count = 1;
            for(int k = 1; k<s.length(); k++)
            {
                char curr = s.charAt(k);
                if(curr==prev)
                {
                    count++;
                }
                else
                {
                    sb.append(count+""+prev);
                    count = 1;
                }
                prev = curr;
                if(k==s.length()-1)
                {
                    sb.append(count+""+curr);
                }
            }
            if(s.length()==1) sb.append("11");
            // System.out.println(i+"="+sb);
            s = sb.toString();
        }
        return s;
    }
}

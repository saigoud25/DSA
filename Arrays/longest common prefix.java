longest common prefix
https://practice.geeksforgeeks.org/problems/cf0cd86c66d07222499f84ec22dbcf6cae30e848/1#


/*
->First find the smallest length(minLength) of strings
->check the all positions whether they are equal or not upto minLength times
*/
class Solution
{
    public String lcp(String s[],int n)
    {
        // Write your code here
        int minLength = Integer.MAX_VALUE;
        for(String a : s)
        {
            if(a.length()<minLength)
            {
                minLength = a.length();
            }
        }
        
        int count = 0;
        for(int i = 0; i<minLength; i++)
        {
            char ch = s[0].charAt(i);
            
            for(int j = 0; j<n; j++)
            {
                // System.out.println(ch);
                if(s[j].charAt(i) != ch)
                {
                    if(count==0) return "-1";
                    return s[j].substring(0, count);
                }
            }
            count++;
            
        }
        if(count==0) return "-1";
        return s[0].substring(0, count);
    }
}

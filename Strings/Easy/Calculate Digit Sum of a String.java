/*
2243. Calculate Digit Sum of a String
https://leetcode.com/contest/weekly-contest-289/problems/calculate-digit-sum-of-a-string/



->Traverse through the s string and the elements silmultaneously
->keep adding the string elements until reach the k, 
    ->If i==k, concatenate the sum to the temp string
    ->After traversing the 's' string if there is lefet over sum append it to the temp
    ->Finally replace the 'S' with the temp string, iterate while loop until s.length<k
*/
class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k)
        {
            String temp = "";
            int sum = 0;
            int i = 0;
            for(char ch : s.toCharArray())
            {
                sum += ch - '0';
                i++;
                if(i==k)
                {
                    temp += sum;
                    sum = 0;
                    i = 0;
                }
            }
            if(i<k && i!=0) 
            {
                temp += sum;
            }
            s = temp;
        }
        
        return s;
    }
}

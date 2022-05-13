Column name from a given column number
https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1/#


/*
->Add the last value to the StringBuilder
->Divide the (n-1) by 26
*/
class Solution
{
    String colName (long n)
    {
        // your code here
        StringBuilder sb = new StringBuilder();
        while(n>0)
        {
            char ch = (char)(65+(n-1)%26);
            sb.append(ch);
            n = (n-1)/26;
        }
        
        return sb.reverse().toString();
    }
}

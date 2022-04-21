/*
Recursively remove all adjacent duplicates
https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1
https://youtu.be/AwyrAQANCFE

->First remove the adjacent duplicate elements
->If the length of temp String is equal to length of original string,
    ->I.e., there are no adjacent duplicates in the string, return the string
    ->If lengths are not same then there may be adjacent duplicates available,
    ->So call the fuction with temp String
*/
class Solution{
    String remove(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<s.length())
        {
            int j = i+1;
            
            while(j<s.length() && s.charAt(j)==s.charAt(i))
            {
                j++;
            }
            if(j == i+1)
            {
                sb.append(s.charAt(i));
            }
            i = j;
        }
        if(sb.length()!=s.length())
        {
            return remove(sb.toString());
        }
        
        return sb.toString();
    }
}

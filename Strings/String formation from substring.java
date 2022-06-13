String formation from substring
https://practice.geeksforgeeks.org/problems/string-formation-from-substring2734/1#


/*
->Double(concatenete s+s) the given string and store it in the temp String
->Remove the first and last characters from the temp String
->If the s is a substring of the temp return 1, else 0
*/

class Solution {
    int isRepeat(String s) {
        // code here
        String temp = s+s;
        temp = temp.substring(1, temp.length()-1);
        
        if(temp.contains(s)) return 1;
        
        return 0;
    }
}

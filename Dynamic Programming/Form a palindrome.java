Form a palindrome
->Minimum number of characters to be inserted to convert it to palindrome.
https://practice.geeksforgeeks.org/problems/form-a-palindrome2544/1#
https://youtu.be/xPBLEj41rFU
https://youtu.be/NPZn9jBrX8U

/*
->To find Longest Common Subseqence
https://youtu.be/-zI4mrF2Pb4 
->Minimum Insertion to make Palindrome
https://youtu.be/xPBLEj41rFU
->Minimum number of characters to be inserted to convert it to palindrome is equal to
->ans = length of String - Longest Common Subsequence (S, S.reverse())
*/
class Solution{
    int[][] arr;
    int findMinInsertions(String S){
        // code here
        arr = new int[S.length()][S.length()];
        String S2 = new StringBuilder(S).reverse().toString();
        
        return S.length()-lcs(S, S2, S.length()-1, S2.length()-1);
    }
    
    int lcs(String s1, String s2, int i, int j)
    {
        if(i<0 || j<0) return 0;
        if(arr[i][j] != 0) return arr[i][j];
        if(s1.charAt(i)==s2.charAt(j)) 
        {
            return arr[i][j] = (1 + lcs(s1, s2, i-1, j-1));
        }
        
        return arr[i][j] = Math.max(lcs(s1, s2, i-1, j), lcs(s1, s2, i, j-1));
    }
}

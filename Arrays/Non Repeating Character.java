Non Repeating Character
https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1/#

/*
->Create an array of length 26, and update the array with frequency of characters
->Iterate through charaters in a string,
->If the frequency of character is one, return the character
->If no element has 1 frequency return '$'
*/
class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        int[] arr = new int[26];
        for(char ch : S.toCharArray())
        {
            arr[ch-'a']++;
        }
        char ch = '$';
        
        for(int i = 0; i<S.length(); i++)
        {
           
            if(arr[S.charAt(i)-'a']==1)
            {
                ch = S.charAt(i);
                break;
            }
        }
        
        return ch;
    }
}

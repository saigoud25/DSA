Implement Atoi
https://practice.geeksforgeeks.org/problems/implement-atoi/1#

Example 1:
Input:
str = 123
Output: 123
	
Example 2:
Input:
str = 21a
Output: -1
Explanation: Output is -1 as a


class Solution
{
    int atoi(String str) {
	// Your code here
	    String temp = "";
	    int number = 0;
	    int i = 0;
	    
	    for(i = 0; i<str.length(); i++)
	    {
	       int num = str.charAt(i) - '0';
	       if(num>=0 && num<=9)
	       {
	           temp += num;
	       }
	       else if(str.charAt(i)=='-') 
	       {
	           temp += '-'; //If string is negative
	       }
	       else
	       {
	           return -1;
	       }
	    }

	    number = Integer.parseInt(temp);
	    
	    return number;
    }
}

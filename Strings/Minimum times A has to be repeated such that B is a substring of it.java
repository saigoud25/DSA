Minimum times A has to be repeated such that B is a substring of it
https://practice.geeksforgeeks.org/problems/5ef42ba605fff6cd60b1b2dd2ee230ade1fa25b0/1

/*
->First set position of i and j at a same locations
->If characters at both positions are equal, increment i & j, return -1;
->If i reached the end posiotion of A, then increment count and set i to 0
->Return 0;
*/
class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int count = 1;
        int i = 0, j = 0;
        while(i<A.length())
        {
            if(A.charAt(i)==B.charAt(j))
            {
                if(i+1<A.length())
                {
                    if(A.charAt(i+1)==B.charAt(j+1)) break;
                }
                else if(A.charAt(0)==B.charAt(j))
                {
                    break;
                }
            }
            i++;
        }

        while(j<B.length())
        {
            if(i==A.length())
            {
                count++;
                i = 0;
            }
            if(A.charAt(i)==B.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                return -1;
            }
        }
        return count;
    }
};

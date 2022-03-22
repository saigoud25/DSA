1663. Smallest String With A Given Numeric Value
https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

/*
->Using greedy approach
->fill the string from the end
->First check 'z', whether it fits or not, if not fits check 'y'.....
->To check whether an character fits or not,
    ->the cost(k)-ch >= min_cost-1
*/
class Solution {
    public String getSmallestString(int n, int k) {
        int min_cost = n;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<n; i++)
        {
            for(int j = 26; j>=1; j--)
            {
                char ch = (char)(96+j);
                if(k-j >= min_cost-1)
                {
                    str.append(ch);
                    k -= j;
                    min_cost--;
                    break;
                }
            }
        }
        return str.reverse().toString();
    }
}

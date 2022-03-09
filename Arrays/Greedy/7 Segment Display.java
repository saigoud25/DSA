7 Segment Display
https://practice.geeksforgeeks.org/problems/7-segment-display0752/1#


/*
->First find the Number of segments are given(cost)
->Min_Cost is the minimum cost to fill the N elements
->traverse from 0 to N
    ->first check 0 fits, if it fits then reduce cost by 7(arr[0]) and Min_Cost by 2
    ->else check other elements in ascending order
    ->To check whether an element fits or not
        ->cost-arr[j] should be greater than or equals Min_Cost-2
        ->the last element(N) cost should equals min_cost
*/

class Solution {
    static String sevenSegments(String S, int N) {
        // code here
        int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 5}; 
        
        String ret = "";
        int cost = 0;
        for(int i = 0; i<N; i++)
        {
            int ind = S.charAt(i)-'0';
            cost += arr[ind];
        }
        
        int min_cost = 2*N;
        for(int i = 0; i<N; i++)
        {
            if(min_cost==0) break;
            for(int j = 0; j<=9; j++)
            {
                if(cost-arr[j]>=min_cost-2)
                {
                    if(i+1==N && cost-arr[j]!=min_cost-2)
                    {
                        continue;
                    }
                    cost -= arr[j];
                    min_cost -= 2;
                    ret += j;
                    break;
                }
            }
        }

        return ret;
    }
};

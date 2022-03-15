Bitwise AND of the Array
https://practice.geeksforgeeks.org/problems/5109f04a157ca54bbb373477b1afeec22e7f1812/1
https://youtu.be/zUUaDh2PrF0

/*
https://youtu.be/zUUaDh2PrF0
->Traverse from 30, count all values val&mask >= mask
*/
class Solution 
{ 
    int count(int N, int A[], int X) 
    {   
        // code here
        int p = 0, ans = N;
        for(int i = 30; i>=0; i--)
        {
            
            if((X&(1<<i)) > 0)
            {
                p = p | (1<<i);
            }
            else
            {
                int temp =  p | (1<<i);
                int count = 0;
                for(int val : A)
                {
                    if((val&temp)>=temp)
                    {
                        count++;
                    }
                }
                ans = Math.min(ans, N-count);
            }
        }
        return ans;
    }
}

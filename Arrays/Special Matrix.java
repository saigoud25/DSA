Special Matrix
https://practice.geeksforgeeks.org/problems/special-matrix4201/1#
https://youtu.be/zg5v2rlV1tM?t=195

//User function Template for Java
/*
->Same as counting paths(https://youtu.be/zg5v2rlV1tM?t=195)
->Here ignore the blocked positions
->count = helper(i+1, j)+helper(i, j+1) if any of these posions are blocked make that 0
*/
class Solution
{
    public int FindWays(int n, int m, int[][] bc)
    {
        // Code here
        int arr[][] = new int[n+1][m+1];
        int arr2[][] = new int[n+1][m+1];
        
        for(int i = 0; i<bc.length; i++)
        {
            arr2[bc[i][0]][bc[i][1]] = -1;
        }
        arr[0][1] = 1;
        arr[1][0] = 1;
        for(int i = 1; i<=n; i++)
        {
            if(arr[i-1][1]==1 && arr2[i][1]==0)
            {
                arr[i][1] = 1;
            }
        }
        for(int i = 1; i<=m; i++)
        {
            if(arr[1][i-1]==1 && arr2[1][i]==0)
            {
                arr[1][i] = 1;
            }
        }
        for(int i = 2; i<=n; i++)
        {
            for(int j = 2; j<=m; j++)
            {
                if(arr2[i][j]==0)
                {
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
                }
            }
        }
 
        return arr[n][m]%1000000007;
    }
}

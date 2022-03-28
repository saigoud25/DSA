547. Number of Provinces
https://leetcode.com/problems/number-of-provinces/
https://youtu.be/2Dl3_h4TNZY

/*
https://youtu.be/2Dl3_h4TNZY
->DFS throgh each node and keep track of visited node
->Count the number of DFS happened in main function
*/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for(int i = 0; i<isConnected.length; i++)
        {
            if(isConnected[i][i] == 1)
            {
                dfs(isConnected, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] M, int i)
    {
        if(M[i][i] == 0) return;
        for(int j = 0; j<M.length; j++)
        {
            if(M[i][j] == 1)
            {
                M[i][j] = 0;
                dfs(M, j);       
            }
        }
    }
}

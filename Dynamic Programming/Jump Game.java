Jump Game
https://practice.geeksforgeeks.org/problems/jump-game/1/#

/*
->Using DP
->Create a Valid boolean Array, to know whether we can start from that position
->mark valid array true, from A[i] steps,
->If valid[N-1] is true return 1, else 0
*/

class Solution {
    static int canReach(int[] A, int N) {
        // code here
        boolean[] valid = new boolean[N];
        if(A[0]==0) return 0;
        valid[0] = true;
        
        for(int i = 0; i<N; i++)
        {
            if(A[i]!=0 && valid[i]==true)
            {
                for(int j = i+1; j<=i+A[i] && j<N; j++)
                {
                    valid[j] = true;
                }
                if(valid[N-1]==true) return 1;
            }
        }
        
        return 0;
    }
};

2139. Minimum Moves to Reach Target Score
https://leetcode.com/problems/minimum-moves-to-reach-target-score/

/*
->Start from target
->If target is even divide by 2, else decrement by 1
->Iterate the loop until target>0 and maxDouble>0
*/
class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        
        while(target>0 && maxDoubles>0)
        {
            if(target%2==0)
            {
                target /= 2;
                maxDoubles--;
            }
            else
            {
                target--;
            }
            moves++;
        }
        
        return target+moves-1;
    }
}

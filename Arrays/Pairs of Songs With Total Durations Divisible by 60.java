1010. Pairs of Songs With Total Durations Divisible by 60
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

/*
->Create an array with 60 length
->for each element find for it's pair in remainder array
->If found add the number of pairs (count += r[60-rem])
->Increment rem index by 1
*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] r = new int[60];
        int count = 0;
        for(int i : time)
        {
            int rem = i%60;
            if(rem==0)
            {
                count += r[0];
            }
            else
            {
                count += r[60-rem];
            }
            r[rem]++;
        }
        return count;
    }
}

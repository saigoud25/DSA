458. Poor Pigs
https://leetcode.com/problems/poor-pigs/


/*
https://www.linkedin.com/posts/mayank-singh-1004981a4_poor-pigs-activity-6961660239892869120-OvKW/?utm_source=linkedin_share&utm_medium=android_app
*/
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest/minutesToDie;
        
        int pigs = 0;
        
        while(Math.pow(rounds+1, pigs) < buckets) pigs++;
        
        return pigs;
    }
}

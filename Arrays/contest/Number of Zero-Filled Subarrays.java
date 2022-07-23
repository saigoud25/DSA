2348. Number of Zero-Filled Subarrays
https://leetcode.com/problems/number-of-zero-filled-subarrays/

/*
->Count the number of contiguous zero's and add the possible Subarrays to the sum
*/
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long sum = 0l;
        for(int i : nums) {
            if(i==0) {
                count++;
            }
            else {
                sum += count*(count+1)/2;
                count = 0;
            }
        }
        if(count != 0) {
            sum += count*(count+1)/2;
        }
        
        return sum;
    }
}

985. Sum of Even Numbers After Queries
https://leetcode.com/problems/sum-of-even-numbers-after-queries/


/*
->Traverse throgh the Queries
->If the index value is even substract the value from the sum
->Add the val to the index value
->If the new value is even, add it to the sum
*/
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int pos = 0;
        int sum = 0;
        
        for(int i : nums) {
            if(i%2==0) sum += i;
        }
        
        for(int[] i : queries) {
            if(nums[i[1]]%2 == 0) {
                sum -= nums[i[1]];
            }
            
            nums[i[1]] += i[0];
            
            if(nums[i[1]]%2 == 0) {
                sum += nums[i[1]];
            }
            
            res[pos++] = sum;
        }
        
        return res;
    }
}

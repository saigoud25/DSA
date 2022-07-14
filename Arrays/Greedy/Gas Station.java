134. Gas Station
https://leetcode.com/problems/gas-station/
https://youtu.be/3wUa7Lf1Xjk

/*
https://youtu.be/3wUa7Lf1Xjk
->Find the TotalSum, if it's lessthan 0 simply return the -1
->While iterating add the difference to the sum, if sum is lessthan 0, make start as next index and sum as 0
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, totalSum = 0;
        int n = gas.length, start = 0;
        for(int i = 0; i<gas.length; i++)
        {
            int ele = gas[i] - cost[i];
            totalSum += ele;
            sum += ele;
            
            if(sum<0)
            {
                sum = 0;
                start = i+1;
            }
        }

        return (totalSum < 0) ? -1 : start;
    }
}

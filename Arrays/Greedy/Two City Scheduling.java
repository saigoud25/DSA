1029. Two City Scheduling
https://leetcode.com/problems/two-city-scheduling/

/*
->Sort the 2D arrays based on the differences
->add 0 to length/2 elements as A city cost 
->add length/2 to length elements as B city cost
*/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        // System.out.println(Arrays.deepToString(costs));
        int sum = 0;
        for(int i = 0; i<costs.length/2; i++)
        {
            sum += costs[i][0];
        }
        for(int i = costs.length/2; i<costs.length; i++)
        {
            sum += costs[i][1];
        }
        return sum;
    }
}

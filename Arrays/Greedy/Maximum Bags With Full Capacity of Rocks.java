2279. Maximum Bags With Full Capacity of Rocks
https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/

/*
->Using the Sorting & Greedy Approach
->Modify the rocks array according to the required capacity and sort the rocks array
->Now if the rocks[i] is 0 increment count, else subtract it with additionalRocks until additionalRocks is 0
*/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int ar) {
        int count = 0;
        for(int i = 0; i<rocks.length; i++)
        {
            rocks[i] = (capacity[i]-rocks[i]);
        }
        Arrays.sort(rocks);
        // System.out.println(Arrays.toString(rocks));
        for(int i : rocks)
        {
            if(i==0) count++;
            else if(i<=ar)
            {
                ar = ar-i;
                count++;
            }
            else
            {
                ar = i-ar;
            }
            if(ar==0) break;
            
        }
        
        return count;
    }
}

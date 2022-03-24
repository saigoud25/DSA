881. Boats to Save People
https://leetcode.com/problems/boats-to-save-people/

/*
->Sort the people array
->Using two pointer method, point start at beginning and end at last
->If sum of start+end values are less than or equal to limit increment start
    ->i.e., two values are considering
    ->If sum is greater, then consider only 1 value(arr[end]) 
->Increment count and decrement end
*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int start = 0, end = people.length-1;
        while(start<=end)
        {
            if(people[start]+people[end]<=limit)
            {
                start++;
            }
            count++;
            end--;
        }

        return count;
    }
}

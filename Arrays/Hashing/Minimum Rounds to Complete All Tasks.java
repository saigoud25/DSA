/*
2244. Minimum Rounds to Complete All Tasks
https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

->Using HashMap
->Store the frequency of numbers in a HashMap
->Traverse the HashMap,
    ->If the frequent element is 1, return -1
    ->If the frequent element is exactly divisible by 3, add freq/3 to the count
    ->Else add (int)(freq/3)
*/
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for(int i : tasks) hm.put(i, hm.getOrDefault(i, 0)+1);
        for(Integer i : hm.keySet())
        {
            int ele = hm.get(i);
            
            if(ele%3==0)
            { 
                count += (ele/3);
            }
            else
            {
                if(ele==1) return -1;
                count += ((int)ele/3) + 1;
            }
        }
        return count;
    }
}

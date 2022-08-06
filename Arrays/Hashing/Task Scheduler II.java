2365. Task Scheduler II
https://leetcode.com/problems/task-scheduler-ii/

/*
->Using HashMap
->If the task is not in the add the task along with current day
->If the task is in map,
    ->Find whether is it possible to complete the task by check past day with current day
    ->Update accordingly
*/
class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long day = 1;
        
        for(int i : tasks) {
            if(map.containsKey(i)) {
                long poss = map.get(i)+space+1;
                if(poss<=day) {
                    map.put(i, day);
                    day++;
                }
                else {
                    map.put(i, poss);
                    day = poss+1;
                }
            }
            else {
                map.put(i, day++);
            }
        }
   
        return day-1;
    }
}

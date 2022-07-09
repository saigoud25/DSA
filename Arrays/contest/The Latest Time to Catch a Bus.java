2332. The Latest Time to Catch a Bus
https://leetcode.com/problems/the-latest-time-to-catch-a-bus/


/*
->Iterate through the passengers array, if pass[i]<=buses[bl] increment i
*/
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] pass, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(pass);

        int bl = 0, pl = 0;

        int tcap = 0, last = 0;
        HashSet<Integer> set = new HashSet();
        boolean full = false;
        
        for(int i = 0; i<pass.length && bl<buses.length; )
        {
            if(pass[i]<=buses[bl] && tcap<capacity)
            {
                set.add(pass[i]);
                tcap++;
                
                if(bl==buses.length-1 && tcap==capacity)
                {
                    last = pass[i];
                    full = true;
                }
                i++;
            }
            else
            {
                bl++;
                tcap = 0;
            }
        }
        
        last--;
        
        if(!full) last = buses[buses.length-1];
        
        
        while(set.contains(last))
        {
            last--;
        }
        
        return last;
    }
}

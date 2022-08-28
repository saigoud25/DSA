2391. Minimum Amount of Time to Collect Garbage2391. Minimum Amount of Time to Collect Garbage
https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/

/*
->First sum the all lengths of garbage
->Find the last postions of P, G and M
->Make travel arrays as prefix sum array
->Add the last positions of P, G, M from the prefix sum array
*/
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int sum = 0;
        //GPM
        int gPos = 0;
        int pPos = 0;
        int mPos = 0;
        
        for(int i = 0; i<garbage.length; i++) {
            String s = garbage[i];
            sum += s.length();
            
            for(char ch : s.toCharArray()) {
                if(ch=='G') gPos = i;
                if(ch=='P') pPos = i;
                if(ch=='M') mPos = i;
            }
        }
        
        for(int i = 1; i<travel.length; i++) {
            travel[i] += travel[i-1];
        }
        
        if(gPos>0) {
            sum += travel[gPos-1];
        }
        if(pPos>0) {
            sum += travel[pPos-1];
        }
        if(mPos>0) {
            sum += travel[mPos-1];
        }
        
        // System.out.println(gPos+" "+ pPos+" "+mPos+" "+ Arrays.toString(travel));
        return sum;
    }
}

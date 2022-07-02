1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

/*
->The idea is to find the max distance of horizontalCuts and max distance verticalCuts
->Multiply the bothe hMax and vMax, handle the modulo
*/
class Solution {
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        int hMax = 0, vMax = 0;
        int prev = 0;
        for(int i : hCuts)
        {
            hMax = Math.max(hMax, i-prev);
            prev = i;
        }
        hMax = Math.max(hMax, h-prev);
        
        prev = 0;
        for(int i : vCuts)
        {
            vMax = Math.max(vMax, i-prev);
            prev = i;
        }
        vMax = Math.max(vMax, w-prev);
        
        long mod = (long)10e8+7;
        long ans = (hMax%mod*vMax%mod)%mod;   
        return (int)ans; 
    }
}

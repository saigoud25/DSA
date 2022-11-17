223. Rectangle Area
https://leetcode.com/problems/rectangle-area/

/*
->First find the individual rectangle Area's 
->Check whether they are overlapping or not, If they are not overlapping return sum of both weights
->Else, Find the Area of Intersecting rectangle and remove it from the total Area
*/
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rectOne = (ax2 - ax1) * (ay2 - ay1);
        int rectTwo = (bx2 - bx1) * (by2 - by1);
        
        if(ax1 >= bx2 || ay1 >= by2 || ax2 <= bx1 || ay2 <= by1) {
            return rectOne + rectTwo;
        }
        
        int l = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int h = Math.min(ay2, by2) - Math.max(ay1, by1);
        
        return (rectOne + rectTwo) - (l * h);
    }
}

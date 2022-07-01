1710. Maximum Units on a Truck
https://leetcode.com/problems/maximum-units-on-a-truck/

/*
->Sort the boxTypes according to numberOfUnitsPerBoxi (i[1])
->Now take the boxes full if the number of boxes is lessthan the truckSize
->Else take required boxes and return count
*/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a , b) -> Integer.compare(b[1], a[1]));
        int count = 0;
        
        for(int[] i : boxTypes)
        {
            if(truckSize>=i[0])
            {
                count += i[0]*i[1];
                truckSize -= i[0];
            }
            else
            {
                count += truckSize*i[1];
                return count;
            }
        }
        
        
        return count;
    }
}

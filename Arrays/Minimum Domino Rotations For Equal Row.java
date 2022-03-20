1007. Minimum Domino Rotations For Equal Row
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
https://youtu.be/9TuF5P-_DD8

/*
->Count the frequencies of elements of tops array (countA)
->Count the frequencies of elements of bottoms array (countB)
->Count if the same element appears in both arrays at ith positions (countSame)
->Check if an element frequncy is equal to length of tops array
    ->If countA[i]+countB[i]-countSame[i] = tops.length
    ->return the number of rotations required, by subtracting Max(countA[i], countB[i]) from tops           length
->Else return -1
*/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] countSame = new int[7];
        
        for(int i = 0; i<tops.length; i++)
        {
            int ele1 = tops[i];
            int ele2 = bottoms[i];
            countA[ele1]++;
            countB[ele2]++;
            if(ele1==ele2) countSame[ele1]++;
        }

        for(int i = 1; i<countA.length; i++)
        {
            int sum = countA[i]+countB[i]-countSame[i];
            
            if(sum==tops.length) 
            {
                int ele = Math.max(countA[i], countB[i]);
                return tops.length-ele;
            }
        }
        return -1;
    }
}

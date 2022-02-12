56. Merge Intervals
https://leetcode.com/problems/merge-intervals/

/*
->Sort the 2D array and compare the adjacent elements, 
->If arr[i]==arr[i+1] they both belong to same interval
->If arr[i][1]>arr[i+1][0] i+1 starting element is less, so they also belong to same interval
*/
class Solution {
    public int[][] merge(int[][] interval) {
        ArrayList<int[]> arr = new ArrayList();
        Arrays.sort(interval, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 1; i<interval.length; i++)
        {
            if(interval[i][0]<=interval[i-1][1])
            {
                interval[i][0] = interval[i-1][0];
                if(interval[i][1]<interval[i-1][1])
                {
                    interval[i][1] = interval[i-1][1];

                }
            }
            
        }
       
        for(int i = 1; i<interval.length; i++)
        {
            int[] temp = new int[2];
            if(interval[i][0]!=interval[i-1][0])
            {
                temp[0] = interval[i-1][0];
                temp[1] = interval[i-1][1];
                arr.add(temp);
            }
        }
        int[] temp = new int[2];
        temp[0] = interval[interval.length-1][0];
        temp[1] = interval[interval.length-1][1];
        arr.add(temp);
        return arr.toArray(new int[arr.size()][]);
    }
}

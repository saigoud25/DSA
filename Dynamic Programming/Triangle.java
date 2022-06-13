120. Triangle
https://leetcode.com/problems/triangle/

/*
->Using Dynamic Programming
https://leetcode.com/problems/triangle/discuss/2144980/From-Memoization-to-DP-or-JAVA-Explanation

->Take minimum of i, i+1 element from previous level and add current value
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> arr = (ArrayList)triangle.get(n-1);
        
        //Tabular Method (Bottom-Up Approach)
        for(int level = n-2; level>=0; level--)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i<=level; i++)
            {
                int val = Math.min(arr.get(i)+triangle.get(level).get(i), arr.get(i+1)+triangle.get(level).get(i));
                temp.add(val);
            }
            
            arr = (ArrayList)temp;
        }
        
        return arr.get(0);
    }
    
    //Recursion Method(Top-Down Approach)
    int helper(int i, int j, int n, int sum, List<List<Integer>> triangle)
    {
        if(j==n)
        {
            return sum;
        }
        
        int p = helper(i, j+1, n, triangle.get(j).get(i)+sum, triangle);
        
        int np = helper(i+1, j+1, n, triangle.get(j).get(i+1)+sum, triangle);
        
        return Math.min(p, np);
    }
}

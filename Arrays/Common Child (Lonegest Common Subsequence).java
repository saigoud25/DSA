Common Child (Longest Common Subsequence)
https://www.hackerrank.com/challenges/common-child/problem
https://www.youtube.com/watch?v=sSno9rV8Rhg

Dynamic Programming Approach:
public static int commonChild(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] arr = new int[m+1][n+1];
        int count = 0;
        
        for(int i=0; i<n; i++)
        {   char a = s2.charAt(i);
            for(int j=0; j<m; j++)
            {
                char b = s1.charAt(j);
                if(a==b)
                {
                    arr[i+1][j+1] = arr[i][j]+1;
                }
                else
                {
                    arr[i+1][j+1] = Math.max(arr[i][j+1], arr[i+1][j]);
                }
            }
        }
        
        count = arr[m][n];
        return count;
}

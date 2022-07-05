2326. Spiral Matrix IV
https://leetcode.com/problems/spiral-matrix/


/*
->Same as Spiral Matrix, Using 4 Pointers
https://leetcode.com/problems/spiral-matrix/

*/
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        for(int i = 0; i<m; i++)
        {
            Arrays.fill(arr[i], -1);
        }
        
        int top = 0, right = n-1;
        int left = 0, down = m-1;
        
        while(true)
        {
            if(head==null) return arr;
            //Traversing from left to right
            for(int i = left; i<=right; i++)
            {
                if(head==null) return arr;
                arr[top][i] = head.val;
                head = head.next;
                // System.out.println(top+" "+i);
            }
            top++;
            //Traversing from top to down
            for(int i = top; i<=down; i++)
            {
                if(head==null) return arr;
                arr[i][right] = head.val;
                head = head.next;
                // System.out.println(i+" "+right);
            }
            right--;
            //Traversing from right to left
            for(int i = right; i>=left; i--)
            {
                if(head==null) return arr;
                arr[down][i] = head.val;
                head = head.next;
                // System.out.println(down+" "+i);
            }
            down--;
            //Traversing from down to top
            for(int i = down; i>=top; i--)
            {
                if(head==null) return arr;
                arr[i][left] = head.val;
                head = head.next;
                // System.out.println(i+" "+left);
            }
            left++;
        }
        
        // return arr;
    }
}

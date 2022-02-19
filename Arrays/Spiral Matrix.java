54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/
https://youtu.be/1ZGJzvkcLsA

/*
https://youtu.be/1ZGJzvkcLsA
->Use four pointers top, down, left and right assign values according to posiotions
->first add left to right and increment top 
->next add top to down and decrement right
->next add right to left and decrement down
->lastly add down to top and increment left
->After every loop check for end position, if it occurs break the while loop
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int dir = 0, top = 0, down = matrix.length-1,left = 0, right = matrix[0].length-1;
        while(true)
        {
            //traversing left to right
            for(int i = left; i<=right; i++)
            {
                int ele = matrix[top][i];
                list.add(ele);
            }
            top++;
            if(left>right || top>down) break;
            //traversing top to down
            for(int i = top; i<=down; i++)
            {
                int ele = matrix[i][right];
                list.add(ele);
            }
            right--;
            if(left>right || top>down) break;
            //traversing right to left
            for(int i = right; i>=left; i--)
            {
                int ele = matrix[down][i];
                list.add(ele);
            }
            down--;
            if(left>right || top>down) break;
            //traversing down to top
            for(int i = down; i>=top; i--)
            {
                int ele = matrix[i][left];
                list.add(ele);
            }
            left++;
            if(left>right || top>down) break;
        }
        return list;
    }
}

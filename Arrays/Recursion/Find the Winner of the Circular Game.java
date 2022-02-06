1823. Find the Winner of the Circular Game
https://leetcode.com/problems/find-the-winner-of-the-circular-game/
https://youtu.be/dzYq5VEMZIg

/*
Method-2: Using Circular LinkedList
->Iterate through the list remove every kth element,
->If length of list is 1, then exit from loop and return that 1 element
*/
class Solution {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for(int i = 1; i<=n; i++)
        {
            res = (res+k)%i;
        }
        return res+1;
        //Method-2
//         List<Integer> list = new LinkedList();
//         for(int i = 1; i<=n; i++)
//         {
//             list.add(i);
//         }
//         int count = 1, pos = 0;
//         while(list.size()>1)
//         {
//             if(pos>=list.size())
//             {
//                 pos = 0;
//             }
//             if(count==k)
//             {
//                 list.remove(pos);
//                 count = 1;
//             }
//             else
//             {
//                 pos++;
//                 count++;
//             }
//         }
//         return list.get(0);
    }
}

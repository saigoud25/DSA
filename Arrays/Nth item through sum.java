Nth item through sum
https://practice.geeksforgeeks.org/problems/nth-item-through-sum3544/1#

/*
->First add the sum values into the HashSet
->Convert that HashSet into the TreeSet for retrieve in sorted order
->return the Nth element from the TreeSet
*/
class Solution{
    static int nthItem(int L1, int L2, int A[], int B[], int N)
    {
        // code here
        Set<Integer> set = new HashSet<Integer>();
        for(int i : A)
        {
            for(int j : B)
            {
                set.add(i+j);
            }
        }
        if(set.size()<N) return -1;

        TreeSet<Integer> tSet = new TreeSet<>(set);
        int count = 1;
        for(Integer i : tSet)
        {
            if(count==N)
            {
                return i;
            }
            count++;
        }
        return -1;
    }
}

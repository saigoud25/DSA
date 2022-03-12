Check Mirror in N-ary tree
https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree1528/1#

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // code here
        HashMap<Integer, ArrayList<Integer>> hm1 = new HashMap();
        HashMap<Integer, ArrayList<Integer>> hm2 = new HashMap();
        for(int i = 0; i<A.length; i+=2)
        {
            if(hm1.containsKey(A[i]))
            {
                hm1.get(A[i]).add(A[i+1]);
            }
            else
            {
                hm1.put(A[i], (new ArrayList()));
                hm1.get(A[i]).add(A[i+1]);
            }
            if(hm2.containsKey(B[i]))
            {
                hm2.get(B[i]).add(B[i+1]);
            }
            else
            {
                hm2.put(B[i], (new ArrayList()));
                hm2.get(B[i]).add(B[i+1]);
            }
        }
        for(Integer i : hm1.keySet())
        {
            ArrayList<Integer> arr1 = hm1.get(i);
            ArrayList<Integer> arr2 = hm2.get(i);
            if(arr1.size() != arr2.size()) return 0;
            int start = 0, end = arr1.size()-1;
            while(start<arr1.size() && end>=0)
            {
                if(arr1.get(start) != arr2.get(end)) return 0;
                start++;
                end--;
            }
        }
        return 1;
    }
};

Subsets
https://practice.geeksforgeeks.org/problems/subsets-1613027340/1#
and
78. Subsets
https://leetcode.com/problems/subsets/submissions/

//LeetCode
/*
->Add an empty array to ret array
->take an array from ret, add current element to that temp array and add back
->repeat the it until the length of ret array
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        
        for(int i = 0; i<nums.length; i++)
        {
            int ele = nums[i];
            int len = ret.size();
            for(int j = 0; j<len; j++)
            {
                ArrayList<Integer> temp = new ArrayList<>(ret.get(j));
                temp.add(ele);
                ret.add(temp);    
            }  
        }
        
        return ret;
    }
}


//GFG
/*
->Regular Subsets method, Using take or not take an element
->Sort the result 2D ArrayList using Comparator
*/
class Solution
{
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(arr, A, list, 0);
        Collections.sort(arr, new Sort());
        return arr;
    }
    public static void helper(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> A, ArrayList<Integer> list, int i)
    {
        if(i==A.size())
        {
            arr.add(new ArrayList<>(list));
            return;
        }
        list.add(A.get(i));
        helper(arr, A, list, i+1);
        list.remove(list.size()-1);
        helper(arr, A, list, i+1);

        return;
    }
    static class Sort implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
        {
            for(int i = 0; i<Math.min(a.size(), b.size()); i++)
            {
                if(a.get(i)>b.get(i)) return 1;
                else if(a.get(i)<b.get(i)) return -1;
                else continue;
            }
            return a.size()-b.size();
        }
    }
}

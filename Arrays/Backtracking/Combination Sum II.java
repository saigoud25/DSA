40. Combination Sum II
https://leetcode.com/problems/combination-sum-ii/


/*
Same as Combination Sum
https://leetcode.com/problems/combination-sum/

->First sort the candidates array
->In each index we would have 2 options
    ->1. Pick that index (i)
    ->2. Pick the next index (i+1) which value of i+1 is not equa to ith value
->If both index values are same, it leads to the duplicate combinations
*/
class Solution {
    List<List<Integer>> arr;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        arr = new ArrayList<>();
        Arrays.sort(candidates);
        
        helper(0, target, candidates, new ArrayList<Integer>());
        
        return arr;
    }
    
    void helper(int i, int target, int[] candidates, ArrayList<Integer> list)
    {
        if(target==0)
        {
            arr.add(new ArrayList<Integer>(list));
            return;
        }
        if(i==candidates.length) return;
        
        if(target-candidates[i] >= 0)
        {   
            //Adding the same element
            list.add(candidates[i]);
            helper(i+1, target-candidates[i], candidates, list);
            list.remove(list.size()-1);
            int k = i+1;
            while(k<candidates.length)
            {
                if(candidates[i]!=candidates[k])
                {
                    break;
                }
                k++;
            }
            //Adding the next element which is not equal to previos element
            helper(k, target, candidates, list);
        }
        return;
    }
}


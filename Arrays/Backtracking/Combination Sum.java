39. Combination Sum
https://leetcode.com/problems/combination-sum/


/*
->Using Backtracking Method
->First Sort the candidates List, we can ignore remaining elements if target is less than 0
->At each index we would have two options 
    ->First check whether by subtracting that index the target is becoming lessthan 0, in this case just return
    ->1. pick the same element or
    ->2. move to the next element
->If the target is equal to 0, add the new list to the main List
*/
class Solution {
    List<List<Integer>> arr;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            helper(i, target-candidates[i], candidates, list);
            list.remove(list.size()-1);
            
            //Adding the next element
            helper(i+1, target, candidates, list);
        }
        return;
    }
}

46. Permutations
https://leetcode.com/problems/permutations/

/*
->Keep the eye on visited index, if the index is visited ignore it
*/
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        func(nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return list;
    }
    void func(int[] nums, ArrayList<Integer> arr, boolean[] visited)
    {
        if(arr.size()==nums.length)
        {
            list.add(new ArrayList(arr));
        }
        
        for(int i = 0; i<nums.length; i++)
        {
            if(visited[i]) continue;
            
            arr.add(nums[i]);
            visited[i] = true;
            func(nums, arr, visited);
            visited[i] = false;
            arr.remove(arr.size()-1);
        }
    }
}

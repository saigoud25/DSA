2115. Find All Possible Recipes from Given Supplies
https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/


/*
->Create a set and add supplies and future supplies to the set for easily searching
->Add the recipes elements into q, iterate the q,
    ->In the first iteration if not possible to make recipe add the index to a new deque (dupq)
    ->If it is possible to make recipe simply add it to the ans array and supplies
    ->Add the values of dupq into q, (check again if possible are not)
*/
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> arr = new ArrayList<>();
        Set<String> sup = new HashSet<>(Arrays.asList(supplies));
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<recipes.length; i++) q.add(i);
         
        while(true)
        {
            Deque<Integer> dupq = new ArrayDeque<>();
            for(Integer i : q)
            {
                boolean flag = true;
                for(String s : ingredients.get(i))
                {
                    if(!sup.contains(s))
                    {
                        flag = false;
                        dupq.add(i);
                        break;
                    }
                }
                if(flag)
                {
                    arr.add(recipes[i]);
                    sup.add(recipes[i]);
                }
            }
            if(dupq.size()==q.size()) break;
            q = dupq;
        }
        
        return arr;
    }
}

49. Group Anagrams
https://leetcode.com/problems/group-anagrams/


/*
->Convert strs array to sorted strs array
[aet, aet, ant, aet, ant, abt]
->Add the elements into HashMap, store string as key and index as value arry
{aet=[0, 1, 3], abt=[5], ant=[2, 4]}
->Iterate through the HashMap and add elements into ans arr
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans= new ArrayList();
        String[] arr2 = strs.clone();
        HashMap<String, ArrayList<Integer>> map = new HashMap();
        //Step-1
        for(int i = 0; i<strs.length; i++)
        {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            strs[i] = new String(arr);
        }
        // System.out.println(Arrays.toString(strs));
        //Step-2
        for(int i = 0; i<strs.length; i++)
        {
            if(map.containsKey(strs[i]))
            {
                ArrayList<Integer> temp = map.get(strs[i]);
                temp.add(i);
                map.put(strs[i], temp);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList();
                temp.add(i);
                map.put(strs[i], temp);
            }
        }
        // System.out.println(map);
        //Step-3
        for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet())
        { 
            ArrayList<String> temp = new ArrayList();
            for(int i : entry.getValue())
            {
                temp.add(arr2[i]);
            }
            ans.add(temp);
        }
        return ans;
    }
}

1647. Minimum Deletions to Make Character Frequencies Unique
https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/submissions/

/*
->Using HashMap count the frequency of the characters, we only need the frequncies here
->Iterate through the frequency values
    ->if the i is present in the set, i.e., we have to delete the number
    ->Decrement number by one and increment the count by 1
    ->If the element not fount in set and it's greater than 0, add the new i value in the set
    ->Take an example to understand
*/
class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        HashSet<Integer> set = new HashSet();
        // System.out.println(set);
        
        int count = 0;
        
        for(Integer i : map.values())
        {
            while(set.contains(i) && i>0)
            {
                i--;
                count++;
            }
            if(i!=0)
            {
                set.add(i);
            }
            
        }
        
        return count;
    }
}

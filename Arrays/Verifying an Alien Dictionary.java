953. Verifying an Alien Dictionary
https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length==1) return true;
        
        HashMap<Character, Integer> hm = new HashMap();
        
        for(int i = 0; i<26; i++)
        {
            hm.put(order.charAt(i), i);
        }
        // System.out.println(hm);
        for(int i=1; i<words.length; i++)
        {
            String s1 = words[i-1];
            String s2 = words[i];
            if(hm.get(s1.charAt(0))<hm.get(s2.charAt(0))) continue;
            if(hm.get(s1.charAt(0))>hm.get(s2.charAt(0))) return false;
            
            int n1 = s1.length(), a = 0;
            int n2 = s2.length(), b = 0;
            int max = Math.max(n1,n2);
            int flag = 0;
            while(a<n1 && b<n2)
            {
                    if(hm.get(s1.charAt(a))<hm.get(s2.charAt(b))) 
                    {
                        flag = 1;
                        break;
                    }
                    else if(hm.get(s1.charAt(a))<=hm.get(s2.charAt(b)))
                    {
                        a++;
                        b++;
                    }
                    else 
                    {
                        return false;
                    }               
            }
            if(n1>n2 && flag == 0) return false;
        }
        return true;
    }
}

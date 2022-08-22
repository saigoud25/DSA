936. Stamping The Sequence
https://leetcode.com/problems/stamping-the-sequence/
https://youtu.be/e3SR3NpebEU


/*
https://youtu.be/e3SR3NpebEU
https://leetcode.com/problems/stamping-the-sequence/discuss/201546/12ms-Java-Solution-Beats-100


->Try to convert target array to -> "*, *, *, *, *"
->Check whether the position can be replacable, If yes replace the characters with '*'
->Count the number of stars while replacing
*/
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        boolean[] visited = new boolean[T.length];
        ArrayList<Integer> list = new ArrayList<>();
        int stars = 0;
        
        while(stars < target.length()) {
            boolean changed = false;
            for(int i = 0; i<=(T.length-S.length); i++) {
                if(!visited[i] && canReplace(i, S, T)) {
                    stars = doReplace(T, S.length, i ,stars);
                    list.add(i);
                    changed = true;
                    visited[i] = true;
                    
                    if(stars==T.length) break;
                }
                
            }
            
                    
            if(!changed) {
                return new int[0];
            }
        }
        
        int[] ans = new int[list.size()];
        
        for(int i = 0; i<ans.length; i++) {
            ans[i] = list.get(ans.length-i-1);
        }
        
        return ans;
    }
    
    public boolean canReplace(int k, char[] S, char[] T) {
        for(int i = 0; i<S.length; i++) {
            if(T[k+i]!='*' && S[i]!=T[k+i]) {
                return false;
            }
        }
        return true;
    }
    
    public int doReplace(char[] T, int k, int i, int stars) {
        for(int j = i; j<(i+k); j++) {
            if(T[j] != '*') {
                T[j] = '*';
                stars++;
            }
        }
        return stars;
    }
}

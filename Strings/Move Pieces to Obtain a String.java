2337. Move Pieces to Obtain a String
https://leetcode.com/problems/move-pieces-to-obtain-a-string/
https://youtu.be/313W6T134SE


/*
https://youtu.be/313W6T134SE

->Ignore all the '_' while traversing
->If start.charAt(s) != target.chatAt(t) return true
->If the both Characters are 'L' and the position of s<t return false
->If the both Characters are 'R' and the posiotion of s>t return false
*/
class Solution {
    public boolean canChange(String start, String target) {
        int s = 0;
        int t = 0;
        
        int sn = start.length(), tn = target.length();
        
        if(sn != tn) return false;
        
        while(s<sn || t<tn)
        {
            while(s<sn && start.charAt(s)=='_')
            {
                s++;
            }
            while(t<tn && target.charAt(t)=='_')
            {
                t++;
            }
            
            if(s==sn && t==tn) return true;
            
            if(s==sn || t==tn || start.charAt(s) != target.charAt(t)) return false;
            
            if(s<sn && t<tn)
            {
                if(target.charAt(t)=='L' && s < t) return false;
                if(target.charAt(t)=='R' && s > t) return false;
            }
            
            s++;
            t++;
        }
        
        return true;
    }
}

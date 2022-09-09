1996. The Number of Weak Characters in the Game
https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

/*
->Sort the array in ascending order based on first values
    ->If both fist values are same, compare second values, the highest value element should comes first
    ->If same first values then sort in Descending order
->Iterate from back side, maintain a max variable
->If the second element is less than max then increment max
->Update the max value in each iteration
*/
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if(a[0]==b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            
            return Integer.compare(a[0], b[0]);
        });
        // [1,5], [1,3], [2,4], [2,1], [3, 15], [3,7], [4,8]

        int n = properties.length-1;
        int max = properties[n][1];
        int count = 0;
        
        for(int i = n-1; i>=0; i--) {
            if(properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return count;
    }
}

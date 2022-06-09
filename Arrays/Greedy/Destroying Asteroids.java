2126. Destroying Asteroids2126. Destroying Asteroids
https://leetcode.com/problems/destroying-asteroids/

/*
->Sort the asteroids
->Iterate from the starting of asteroids array
->If the mass is greterthan or equal to the asteroids[i], add the weight of that element to the mass, else return false
*/
class Solution {
    public boolean asteroidsDestroyed(int mas, int[] asteroids) {
        long mass = mas;
        Arrays.sort(asteroids);
        for(int i = 0; i<asteroids.length; i++)
        {
            if(mass>=asteroids[i])
            {
                mass += asteroids[i];
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}

991. Broken Calculator
https://leetcode.com/problems/broken-calculator/
https://youtu.be/htdMVvGM4iY

/*
https://youtu.be/htdMVvGM4iY
->Solve from back, i.e., make target less than or equal to startValue
->If startValue is greater than target return startValue-target
->If target is a even number, divide target by 2
->If target is odd increment target b 1
*/
class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue>=target) return startValue-target;
        
        if(target%2 == 0)
        {
            return 1 + brokenCalc(startValue, target/2);
        }
        
        return 1 + brokenCalc(startValue, target+1);
    }
}

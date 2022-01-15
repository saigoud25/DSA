Picking Numbers
https://www.hackerrank.com/challenges/picking-numbers/problem

public static int pickingNumbers(List<Integer> a) {
    // Write your code here
        int high = 1, temp = 0;
        Collections.sort(a);
        
        int start = 0, end = 0, n = a.size();
        while(end<n)
        {
            int diff = Math.abs(a.get(start)-a.get(end));
            if(diff<=1)
            {
                temp++;
                end++;
            }
            else
            {
                temp--;
                start++;
            }
            high = Math.max(temp, high);
        }
        return high;
    }

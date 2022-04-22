Theft at World Bank
https://practice.geeksforgeeks.org/problems/theft-at-the-world-bank2156/1#

/*
->Create a TreeMap store the profit per one unit as a key and weight as a value
->Traverse the TreeMap and add the profits to ans until C==0
->weight * (profit per one unit weight) = total profit
*/

class Solution
{
    public double maximumProfit(int N, long C, long w[], long p[])
    {
        // Code here
        TreeMap<Double, Long> map = new TreeMap<>(Collections.reverseOrder());
        double ans = 0.0;
        for(int i = 0; i<N; i++)
        {
            if((int)Math.sqrt(w[i])*(int)Math.sqrt(w[i]) != w[i])
            {
                double ele = (double)p[i]/w[i];
                map.put(ele, w[i]);
            }
        }
        for(Double k : map.keySet())
        {
            long val = map.get(k);
            if(C > val)
            {
                C -= val;
                ans += val*k;
            }
            else
            {
                ans += (val-(val-C))*k;
                return ans;
            }
        }
        
        return ans;
    }
}

973. K Closest Points to Origin
https://leetcode.com/problems/k-closest-points-to-origin/

/*
1. calculate the distance of every point and store it in TreeMap, distance as key and points as value
2. return top k elements from TreeMap

*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ret = new int[k][2];
        Map<Double, ArrayList> hm = new TreeMap();
        for(int[] i : points)
        {
            int a = i[0];
            int b = i[1];
            double distance = Math.sqrt((a*a)+(b*b));
            if(!hm.containsKey(distance)) hm.put(distance, new ArrayList());
            hm.get(distance).add(i);
            
        }
        int j = 0;
        for(Map.Entry<Double, ArrayList> i : hm.entrySet())
        {
            if(j==k) return ret;
            ArrayList<int[]> temp = i.getValue();
            while(!temp.isEmpty())
            {
                int[] t = temp.get(0);
                temp.remove(0);
                ret[j][0] = t[0];
                ret[j][1] = t[1];
                j++;
            }
            
        }
        return ret;
    }
}

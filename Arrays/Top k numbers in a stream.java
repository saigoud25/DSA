Top k numbers in a stream
https://practice.geeksforgeeks.org/problems/top-k-numbers3425/1

explanation:
https://www.geeksforgeeks.org/find-top-k-or-most-frequent-numbers-in-a-stream/


class Solution
{ 
    static ArrayList<Integer> kTop(int[] a, int n, int k) 
    { 
        //code here.
        int[] arr = new int[k+1];
        ArrayList<Integer> printArray = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
       
        for(int i = 0; i<k+1; i++)
        {
            hm.put(i, 0);
        }
        
        for(int i = 0; i<n; i++)
        {
            if(hm.containsKey(a[i]))
            {
                hm.put(a[i], hm.get(a[i])+1);
            }
            else
            {
                hm.put(a[i], 1);
            }
            
            arr[k] = a[i];
            
            int ind = 0;
            for(int y = 0; y<=k; y++)
            {
                if(arr[y] == a[i])
                {
                    ind = y;
                    break;
                }
            }
            ind--;
            
            while(ind>=0)
            {
                if(hm.get(arr[ind]) < hm.get(arr[ind+1]))
                {

                    int temp = arr[ind];
                    arr[ind] = arr[ind+1];
                    arr[ind+1] = temp;
                    
                }
                else if(hm.get(arr[ind])==hm.get(arr[ind+1]) && arr[ind]>arr[ind+1])
                {
                    int temp = arr[ind];
                    arr[ind] = arr[ind+1];
                    arr[ind+1] = temp;
                }
                else break;
                
                ind--;
            }
            
            for(int x = 0; x<k && arr[x]!=0; x++)
            {
                printArray.add(arr[x]);
            }
        }
        
        return printArray;
    }
}

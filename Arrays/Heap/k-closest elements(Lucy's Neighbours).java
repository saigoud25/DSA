Lucy's Neighbours
https://practice.geeksforgeeks.org/problems/20b8ec4db3f8da0697acdd3d54d9af9f76405443/1/#


/*
-Using PriorityQueue
->Create 2 pq's, 
    ->add elements less than x into pq1 (Max Hea)
    ->add elements greater than x into pq1 (Min Heap)
->Compare pq1 and pq2 peek elements add the element into ans array
->Sort tha ans array and return the array
*/

class Solution 
{ 
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
	    // Your code goes here 
	    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
	    PriorityQueue<Integer> pq2 = new PriorityQueue<>();
	    ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i : arr)
        {
            if(i<=x)
            {
                pq1.add(i);
            }
            else
            {
                pq2.add(i);
            }
        }
	   
	   // System.out.println(pq1);
	   // System.out.println(pq2);
	    
	    while(k>=1 && pq1.peek()!=null && pq2.peek()!=null)
	    {
	        int ele1 = x-pq1.peek();
	        int ele2 = pq2.peek()-x;
	        
	        if(ele1>ele2)
	        {
	            ans.add(pq2.poll());
	        }
	        else
	        {
	            ans.add(pq1.poll());
	        }
	        k--;
	    }
	    
	    if(k>=1 && !pq1.isEmpty())
	    {
	        while(k>=1)
	        {
	            ans.add(pq1.poll());
	            k--;
	        }
	    }
	    
	    if(k>=1 && !pq2.isEmpty())
	    {
	        while(k>=1)
	        {
	            ans.add(pq2.poll());
	            k--;
	        }
	    }

	    Collections.sort(ans);
	    return ans;
	}
}

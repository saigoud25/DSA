Find Missing And Repeating
https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/

Using Cyclic Sort



class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int ret[] = new int[2];
        int i = 0;
        int temp = 0;
        
        while(i<n)
        {
            
            if(arr[arr[i]-1] == arr[i]) i++;
            else if(arr[i] != i+1)
            { 
                temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
            else{
                i++;
            }
        }
        
        
        for(i = 0; i<n; i++)
        {
            if(arr[i] != i+1)
            {
                ret[0] = arr[i];
                ret[1] = i+1;
                break;
            }
        }

        return ret;
    }
}
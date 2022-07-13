Common elements
https://practice.geeksforgeeks.org/problems/common-elements1132/1/


class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int max = 0, temp = 0;
        while(i<n1 && j<n2 && k<n3)
        {
            if(A[i]==B[j] && B[j]==C[k])
            {
                if(C[k]!=temp) arr.add(A[i]);
                temp = A[i];
                i++;
                j++;
                k++;
                continue;
            }
            max = Math.max(Math.max(A[i], B[j]), C[k]);
            
            if(A[i]<max) i++;
            if(B[j]<max) j++;
            if(C[k]<max) k++;
        }
        
        return arr;
    }
}

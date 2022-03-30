Max sum path in two arrays
https://practice.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1/

/*
->Store the sum of elements in sum1 & sum2 until the same value exists
->Add the Maximum of sum1 & sum2 in sum when the array elements are same
->Check when a array traversal completed and another is not done
*/
class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int ar1[], int ar2[])
    {
        // Your code here
        // if(ar1.length==10000 && ar2.length==1000) return 503008440;
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        
        while(i<ar1.length && j<ar2.length)
        {
            if(ar1[i]<ar2[j])
            {
                sum1 += ar1[i];
                i++;
            }
            else if(ar1[i]>ar2[j])
            {
                sum2 += ar2[j];
                j++;
            }
            else{
                
                sum += Math.max(sum1, sum2)+ar1[i];
                // System.out.println(sum);
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        
        while(i<ar1.length || j<ar2.length)
        {
            if(i<ar1.length)
            {
                sum1 += ar1[i++];
                
            }
            if(j<ar2.length)
            {
                sum2 += ar2[j++];
            }
        }
        // System.out.println(sum1+" "+sum2);
        sum += Math.max(sum1, sum2);
        return sum;
    }
}

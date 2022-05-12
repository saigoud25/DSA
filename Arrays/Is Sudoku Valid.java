Is Sudoku Valid
https://practice.geeksforgeeks.org/problems/is-sudoku-valid4820/1/#

/*
Using HashSet
->Sudoku is invalid if
    ->same number is present in entire row, entire column on in box
->Traverse through non zero numbers
->We add the row, columm and box details in a set
for first postion (i=0, j=0, matrix[i][j]=3)
add 3 strings to the set
    ->S1 = row-0-3
    ->S2 = col-0-3
    ->S3 = box-0-3
    ->Use boxNo = (i/3)*3 + j/3 to find the box number
->If the set contains the S1 or S2 or S3 return ), i.e., element already present in the Row or Column or Box
*/
class Solution{
    static int isValid(int matrix[][]){
        // code here
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if(matrix[i][j] != 0)
                {
                    int boxNo = (i/3)*3 + j/3;
                    String s1 = "row-"+i+"-"+matrix[i][j];
                    String s2 = "col-"+j+"-"+matrix[i][j];
                    String s3 = "box-"+boxNo+"-"+matrix[i][j];
                    
                    if(set.contains(s1) || set.contains(s2) || set.contains(s3))
                    {
                        return 0;
                    }
                    
                    set.add(s1);
                    set.add(s2);
                    set.add(s3);
                    // System.out.println(set);
                }
            }
        }
        
        return 1;
    }
}

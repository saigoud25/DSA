Phone directory
https://practice.geeksforgeeks.org/problems/phone-directory4628/1/#

/*
->Add the contact array strings into the Set, To eliminate the repeated strings
->Convert that set into the array, to easy traversal and sort the array
->Iterate through the String "S", add only strings of contacts(con) into new arrays(arr), 
    ->whose S.charAt(0) position is equal to the con[i].charAt(0)
    ->add the arr to the result array,
    ->Now replace add values of arr into the con(copy)
    ->Now in the second iteration, check 2nd position, in 3rd iteration check 3rd posiotion elements
*/
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(contact));
        ArrayList<String> con = new ArrayList<String>(set);
        Collections.sort(con);
        for(int i=0;i<s.length();i++)
        {
            ArrayList<String> arr = new ArrayList<>();
            
            for(int j=0;j<con.size();j++)
            {
                if(con.get(j).length()<i+1) continue;
                
                if(s.charAt(i)==con.get(j).charAt(i))
                {
                    arr.add(con.get(j));
                }
            }
            if(arr.size()==0)
            {
                arr.add("0");
            }
            res.add(arr);
            con = arr;
        }
        return res;
    }
}

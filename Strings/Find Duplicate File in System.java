609. Find Duplicate File in System
https://leetcode.com/problems/find-duplicate-file-in-system/


/*
->Using HashMap
->Store content as a key and ArrayList as a value,
->ArrayList contains paths of files of similar content 
*/
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for(String files : paths) {
            String[] arr = files.split(" ");
            for(int i = 1; i<arr.length; i++) {
                String[] file = arr[i].split("\\(");

                map.putIfAbsent(file[1], new ArrayList<>());
                map.get(file[1]).add(arr[0]+'/'+file[0]);
            }
        }

        for(List<String> list : map.values()) {
            if(list.size()>1) {
                res.add(list);
            }
        }
        return res;
    }
}

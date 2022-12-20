841. Keys and Rooms
https://leetcode.com/problems/keys-and-rooms/

/*
-> Using simple bfs add the 0th room into dq and iterate it
*/
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();

        Queue<Integer> dq = new ArrayDeque<>();
        set.add(0);
        dq.add(0);

        while(!dq.isEmpty()) {
            int len = dq.size();

            for(int i = 0; i<len; i++) {
                for(int k : rooms.get(dq.poll())) {
                    if(!set.contains(k)) {
                        dq.add(k);
                        set.add(k);
                    }
                }
            }
        }

        return set.size()==rooms.size();
    }
}

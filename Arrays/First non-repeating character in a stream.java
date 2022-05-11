First non-repeating character in a stream
https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
https://youtu.be/Jkx1vP3ZkK0


/*
->Using ArrayDeque
->https://youtu.be/Jkx1vP3ZkK0

->Increment the frquency of character in arr
->Add the element into queue
->If the dq.peek() element has more then 1 frequency remove that character from the queue
->Append the dq.peek() character to the string
->If the dq is empty, i.e., no non-repeating charaters so appedn "#"
*/
class Solution
{
    public String FirstNonRepeating(String A)
    {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        Deque<Character> dq = new ArrayDeque<>();
        for(char ch : A.toCharArray())
        {
            arr[ch-'a']++;
            dq.add(ch);
            while(!dq.isEmpty() && (arr[dq.peek()-'a']>1))
            {
                dq.poll();
            }
            if(dq.isEmpty()) sb.append("#");
            else sb.append(dq.peek());
        }
        
        return sb.toString();
    }
}

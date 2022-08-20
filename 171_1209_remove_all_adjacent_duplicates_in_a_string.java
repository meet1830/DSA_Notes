/* 
 * 1209. Remove All Adjacent Duplicates in String II 
Question:
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints:
1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
*/



class Solution {
/*    
brute -> can use two stacks one containing resultant string and other temp stack. traverse the string and everytime put the element in the temp stack. if the peek of main stack is equal to element, then shift the element to the temp stack. continue doing this, if the size of stack becomes equal to k, then discard the stack and move to next iteration or else shift all the elements to the main stack.
    will give tle
    tc -> n*k sc -> n
*/

    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()) {
            Stack<Character> temp = new Stack<>();
            temp.push(c);
            
            while(!st.isEmpty() && st.peek() == c)
                temp.push(st.pop());
            
            if(temp.size() != k) {
                while(!temp.isEmpty()) 
                    st.push(temp.pop());
            }
        }
        
        String res = "";
        while(!st.isEmpty())
            res = st.pop() + res;
        
        return res;
    }
}


// recursive solution -> giving TLE due to test cases
class Solution {
    public String removeDuplicates(String s, int k) {
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1))
                count++;
            else 
                count = 1;
            if(count == k) {
                String reduced = s.substring(0, i - k + 1) + s.substring(i + 1);
                return removeDuplicates(reduced, k);
            }
        }
        
        return s;
    }
}


// can use just one stack by inserting key value pairs of the character and its count instead of counting it in second stack. can use pair class or use int array of size 2. can take integer array as string can be converted to integer. hence string.valueOf will result in numbers.
// tc -> n sc -> n
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && st.peek()[0] == c) 
                st.peek()[1]++;
            else 
                st.push(new int[]{c, 1});
            
            if(st.peek()[1] == k)
                st.pop();
        }
        
        String res = "";
        while(!st.isEmpty()) {
            int[] peek = st.pop();
            String t = "";
            for(int i = 0; i < peek[1]; i++) 
                t += Character.toString(peek[0]);
                
            res = t + res;
        }
        
        return res;
    }
}


// using pairs
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && st.peek().getKey() == c) {
                Pair<Character, Integer> p = st.pop();
                st.push(new Pair<>(p.getKey(), p.getValue() + 1));
            }
            else 
                st.push(new Pair<>(c, 1));
            
            if(st.peek().getValue() == k)
                st.pop();
        }
        
        String res = "";
        while(!st.isEmpty()) {
            Pair<Character, Integer> peek = st.pop();
            String t = "";
            for(int i = 0; i < peek.getValue(); i++) 
                t += peek.getKey();
                
            res = t + res;
        }
        
        return res;
    }
}



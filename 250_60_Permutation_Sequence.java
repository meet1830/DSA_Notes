/* 
 * 60. Permutation Sequence
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
*/



// brute -> finding all permutations, storing them in an arraylist and getting k-1th permutation out of it
// O(n!*n + n!logn!), O(n), O(n) -> recursion in levels auxiliary space

class Solution {
    public String swap(String s, int x, int y) {
        char[] arr = s.toCharArray();
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        
        // converting char array to string
        return new String(arr);
        
        // method 2 - String res = String.valueOf(arr); 
        // method 3 - String res = String.copyValueOf(arr);
        // return res;
    }
    
    public void getPerm(String s, List<String> ans, int idx, List<Character> list) {
        if (idx == s.length()) {
            String add = s;
            ans.add(add);
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            s = swap(s, idx, i);
            getPerm(s, ans, idx + 1, list);
            s = swap(s, idx, i);
        }
    }
    
    public String getPermutation(int n, int k) {
        String s = "";
        for (int i = 1; i <= n; i++)
            s += i;
            
        List<String> ans = new ArrayList<>();
        getPerm(s, ans, 0, new ArrayList<Character>());
        
        Collections.sort(ans, (a,b) -> a.compareTo(b));
        
        return s = ans.get(k - 1 % n);
    }
}



// optimal 
// O(n^2 -> n for loop and other n for removing number from numbers arraylist)
// O(n) -> size of numbers
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        
        // calculating fact(n - 1) and adding numbers to list
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        
        // for 0th order
        k--;
        String ans = "";
        
        while (true) {
            // fact is number of permutations in each group of numbers if permutation is starting with that number.
            // k is the index of max permutation in that group - the index of permutation we want
            // getting index of number that will be at this position in string
            ans = ans + "" + numbers.get(k / fact);
            numbers.remove(k / fact);
            
            if (numbers.size() == 0) 
                break;
            
            // updating k
            k %= fact;
            fact /= numbers.size();
        }
        
        return ans;
    }
}
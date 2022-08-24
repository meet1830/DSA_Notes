/* 
 * 131. Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/



// brute -> generate every subset by calling over each subset in recursion. then check palindrome in base condition. here reducing the number of recursion calls.

// optimal -> partition only when the string between partition is palindrome
// recursion tree
// in first level of recursion make partitions and choose where left side of partition is palindrome
// eg aabb -> a|abb aa|bb aab|b aabb|. here take a|abb and aa|bb
// second level for first -> a|a|bb a|ab|b a|abb| take -> a|a|bb 
// for second -> aa|b|b aa|bb| take -> both
// third level for a|a|bb -> a|a|b|b a|a|bb|
// for aa|b|b -> aa|b|b| -> ans
// for aa|bb| -> ans
// fourth level -> for a|a|b|b -> a|a|b|b| -> ans
// for a|a|bb| -> ans
// hence ans a|a|b|b| a|a|bb| aa|b|b| aa|bb|

// tc -> O(2^n * n * n -> number of subsets * adding and making deepcopy * checking palindrome), O(k * n -> number of subsets * avg length of subset)

class Solution {
    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) 
                return false;
            l++;
            r--;
        }
        
        return true;
    }
    
    public void findPart(String s, int idx, List<String> list, List<List<String>> ans) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            // partitioning from idx to i
            if (isPalindrome(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                findPart(s, i + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        findPart(s, 0, new ArrayList<String>(), ans);
        
        return ans;
    }
}
/* 
 * 686. Repeated String Match
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".


Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

Example 2:
Input: a = "a", b = "aa"
Output: 2
 
Constraints:
1 <= a.length, b.length <= 104
a and b consist of lowercase English letters.
*/


// keep appending a in string until b becomes a substring of a
// keep doing it until the length of string becomes equal to b plus 1 time string a (check example 1)
// if keep checking in the loop itself then will give tle
// O(count * a.length()), O(1)
// can use kmp instead of .contains

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        if (sb.toString().contains(b))
            return count;
        
        if (sb.append(a).toString().contains(b))
            return ++count;
            
        return -1;
    }
}



// using rabin karp algo
// while loop -> making a of same size as b
// first call -> checking if b is substring of source
// second call -> for example 1 -> no of extra characters around the ans same as length of a 
// O(m + n), O(1)
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (a == b && a.equals(b))
            return 0;
        
        int count = 1;
        String source = a;
        while (source.length() < b.length()) {
            source += a;
            count++;
        }
        
        if (rabinKarp(b, source) != -1) 
            return count;
        
        if (rabinKarp(b, source + a) != -1)
            return ++count;
        
        return -1;
    }
    
    private int rabinKarp(String pat, String txt)
    {
        int m = pat.length(), n = txt.length();
        int d = 256;
        int q = 101;
        int h = 1;
        int p = 0;
        int t = 0;
        
        for (int i = 1; i < m; i++) 
            h = (h * d) % q;
            
        for (int i = 0; i < m; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }
        
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                if (txt.substring(i, i + m).equals(pat))
                    return i;
            }
            
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                
                if (t < 0)
                    t += q;
            }
        }
        
        return -1;
    }
}
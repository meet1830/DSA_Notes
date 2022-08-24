/* 
 * 38. Count and Say
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

For example, the saying and conversion for digit string "3322251":

Given a positive integer n, return the nth term of the count-and-say sequence.


Example 1:
Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

Constraints:
1 <= n <= 30
*/



class Solution {
    public String countAndSay(int n) {
        if (n == 1) 
            return "1";
        if (n == 2)
            return "11";
        
        String ans = "11";
        for (int i = 3; i <= n; i++) {
            int count = 1;
            // increase the string length by 1 for loop to run through all chars
            ans += "$";
            String temp = "";
            
            for (int j = 1; j < ans.length(); j++) {
                if (ans.charAt(j) == ans.charAt(j - 1))
                    count++;
                else {
                    temp += (count + "") + ans.charAt(j - 1); 
                    count = 1;
                }
            }
            
            ans = temp + "$";
        }
        
        return ans.substring(0, ans.length() - 1);
    }
}



class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char c = ans.charAt(0);
            
            for (int j = 1; j < ans.length(); j++) {
                if (c != ans.charAt(j)) {
                    sb.append(count);
                    sb.append(c);
                    c = ans.charAt(j);
                    count = 1;
                }
                else
                    count++;
            }
            
            // append for last character
            sb.append(count);
            sb.append(c);
            
            ans = sb.toString();
        }
        
        return ans;
    }
}
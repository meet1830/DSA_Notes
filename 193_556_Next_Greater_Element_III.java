/* 
 * 556. Next Greater Element III
Medium

2605

370

Add to List

Share
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 

Constraints:

1 <= n <= 2^31 - 1
*/


// brute -> find all permutations, and traverse through them to find the next greater element than the input

// optimal
// algorithm
// take example 125431 -> 131245
// 1. find the deflection point -> from last, find the point where the char is not increasing, here from last 5 4 3 1 all increasing, 2 is not increasing, hence it is the first swap index (2) and the index before it is called deflection point (1)
// 2. take the element at first swap index, and find its lowest greater number on the right, here 3 is the lowest greater element that 2. 3 is second swap index
// 3. swap both indexes -> 135421
// 4. reverse string from the deflection point (1) -> 131245
// O(n), O(1)
class Solution {
    public void swap (char[] str, int i, int j) {
        Character temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public void reverseStr(char[] str, int l) {
        int r = str.length - 1;
        while (l < r) {
            swap(str, l, r);
            l++;
            r--;
        }
    }
    public int nextGreaterElement(int n) {
        char[] str = (n + "").toCharArray();
        int size = str.length;
        
        // 1.
        int deflect = size - 1;
        while (deflect > 0) {
            if (str[deflect - 1] < str[deflect])
                break;
            deflect--;
        }
        // if reached the end (array in descending order)
        if (deflect == 0)
            return -1;
        int firstSwapIdx = deflect - 1;
        
        // 2.
        int secondSwapVal = Integer.MAX_VALUE, secondSwapIdx = -1;
        for (int i = firstSwapIdx + 1; i < size; i++) {
            if (str[i] > str[firstSwapIdx]) {
                secondSwapVal = Math.min (str[i], secondSwapVal);
                secondSwapIdx = i;
            }
        }
        
        // 3.
        swap(str, firstSwapIdx, secondSwapIdx);
        
        // 4.
        reverseStr(str, deflect);

        // due to constraints
        Long ans = Long.parseLong(new String(str));
        if (ans <= Integer.MAX_VALUE)
            return ans.intValue();
        else
            return -1;
    }
}
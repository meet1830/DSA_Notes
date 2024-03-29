/* 
 * Maximum of minimum for every window size
You are given an array of ‘N’ integers, you need to find the maximum of minimum for every window size. The size of the window should vary from 1 to ‘N’ only.

For example:
ARR = [1,2,3,4]
Minimums of window size 1 = min(1), min(2), min(3), min(4) = 1,2,3,4
Maximum among (1,2,3,4)  is 4

Minimums of window size 2 = min(1,2), min(2,3),   min(3,4) = 1,2,3
Maximum among (1,2,3) is 3

Minimums of window size 3 = min(1,2,3), min(2,3,4) = 1,2
Maximum among (1,2) is 2

Minimums of window size 4 = min(1,2,3,4) = 1
Maximum among them is 1
The output array should be [4,3,2,1].

Input Format:
The first line of the input contains an integer ‘T’ denoting the number of test cases.

The first line of each test case contains a single positive integer ‘N’ denoting the number of the elements present in the array.

The second line of each test case contains ‘N’ space-separated integers denoting the elements of the array.

Output Format:
The only line of output of each test case should contain ‘N’ space-separated integer such that he ith integer indicates the maximum of minimums of the windows of size ‘i’.

Constraints:
1 <= T <= 100
1 <= N <= 10 ^ 4 
-10 ^ 9 <= ARR[i] <= 10 ^ 9
Where ‘T’ is the number of test cases, ‘N’ is the size of the array and ‘ARR[i]’ is the size of the array elements.
Time Limit: 1 sec

Sample Input 1:
2
4
1 2 3 4
5
3 3 4 2 4    
Sample Output 1:
4 3 2 1
4 3 3 2 2
Explanation For Sample Input 1:
Test case 1:
Already explained in the question.

Test case 2:
Minimums of window size 1 = min(3), min(3), min(4), min(2), min(4) = 3, 3, 4, 2, 4
Maximum among (3, 3, 4, 2, 4) is 4

Minimums of window size 2 = min(3,3), min(3,4), min(4,2), min(2,4) = 3, 3, 2, 2
Maximum among (3, 3, 2, 2) is 3

Minimums of window size 3 = min(3,3,4), min(3,4,2), min(4,2,4) = 3, 2, 2
Maximum among (3, 2, 2) is 3

Minimums of window size 4 = min(3,3,4,2), min(3,4,2,4) = 2, 2
Maximum among (2, 2) is 2

Minimums of window size 4 = min(3,3,4,2,4) = 2
Maximum among them is 2
The output array should be [4,3,3,2,2].

Sample Input 2:
2
5 
45 -2 42 5 -11 
6 
-2 12 -1 1 20 1 
Sample Output 2:
 45 5 -2 -2 -11
 20 1  1 -1 -1 -2
*/


// brute -> for all window sizes (first loop), traverse to each window of size k(second loop), find minimum (third loop) and update maximum
// O(n * k * n), O(1)

public class Solution {
    public static int[] maxMinWindow(int[] arr, int n) {
        int[] ans = new int[n];
        // for each window size
        for (int i = 1; i <= n; i++) {
            // traversing through all windows of that size
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= n - i; j++) {
                // finding minimum in window of that size
                int min = arr[j];
                for (int k = 1; k < i; k++) {
                    if (arr[j + k] < min)
                        min = arr[j + k];
                }
                
                if (max < min)
                    max = min;
            }
            ans[i - 1] = max;
        }
        
        return ans;
    }
}


// better
// sliding window minimum of window size k
// find max in that for each window size and put it in ans array
// O(n * n) -> (sliding window minimum * finding maximum), O(k)


// optimal -> we are calculating minimum again and again
// for that window size k find minimum for that window
// next just check that if the minimum previously calculated for any window size appears in this window by value(not by position). bc we want to find minimum and if it appears then will remain as the ans for that window
// if it appears, then keep that as max for that window size
// if it does not appear then find minimum. it would surely be greater than the minimum calculated previously.
// hence update the max for that window size
// for this find next smaller element on the right as well as on the left for each element of the array
// subtract the indexes of both the arrays and get the length of window for which the element of that index is the minimum of
// create ans array. for each length of window we get from the array, its minimum exists as its index value from the input array. put the minimum as the value in the ans array at the index of window length
// O(n), O(n -> nse arrays)

import java.util.*;
public class Solution {
    private static int[] nseLeft(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    private static int[] nseRight(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public static int[] maxMinWindow(int[] arr, int n) {
        int[] nsel = nseLeft(arr, n);
        int[] nser = nseRight(arr, n);
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        
        // calculate length of window size
        // and fill ans array arr[i] is a possible ans
        // hence take max
        for (int i = 0; i < n; i++) {
            nser[i] = nser[i] - nsel[i] - 1;
            ans[nser[i] - 1] = Math.max(arr[i], ans[nser[i] - 1]);
        }
        
        // some element left to fill
        // fill them by taking values from right side of the array
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        return ans;
    }
}

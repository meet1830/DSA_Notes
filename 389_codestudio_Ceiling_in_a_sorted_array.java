/* 
 * Ceiling in a sorted array

Given a sorted array A of integers having size N and a number X. Your task is to return the ceiling of 'X'. for the given list. Return -1 if the ceiling does not exist.
Ceiling of X is the smallest element in the array greater than or equal to X.

Note: you are not allowed to use inbuild functions like lower_bound() etc.

Input Format :
The first line contains a single integer ‘T’ denoting the number of test cases to run. Then the test cases follow.

The first line of each test case contains two integers ‘N’ and 'X', where N represents the size of the array.

The next line contains N integers, denoting the elements of the given array.

Output Format :
For each test case print a single integer denoting the ceiling of X.

Output for each test case will be printed in a separate line,

Note :
You are not required to print anything; it has already been taken care of. Just implement the function.

Constraints :
1 <= T <= 10      
1 <= N <= 2 * 10^5      
1 <= ai <= 10^9
Time limit: 1 sec

Sample Input 1 :
2
6 5
1 2 3 4 5 6
6 2
1 1 3 4 4 5
Sample Output 1 :
5
3
Explanation Of Sample Input 1 :
For test case 1:
5 is the element in the array greater than equal to X=5.

For test case 2:
3 is the element in the array greater than equal to X=2.

Sample Input 2 :
2
3 7
1 2 9
6 2
1 1 1 1 1 1
Sample Output 2 :
 9
-1

*/



public class Solution {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int l = 0, r = n - 1, result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                result = arr[mid];
                return result;
            }
            if (arr[mid] > x) {
                result = arr[mid];
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
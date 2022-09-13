/* 
 * Least Greater Element
 * 
You are given an array 'ARR' of Integers. Your task is to replace each element of the array with the smallest element, which is strictly greater than that element and is present on the right side of that element in the array i.e. for each valid index ‘i’ replace ARR[i] with the smallest ARR[j] such that ARR[j]>ARR[i] and j>i.
In case there exists no such element satisfying the above conditions for a particular array element, replace it with -1.

For example :
Consider the array ARR = [ 1, 4, 2, 6 ] having 4 elements.
The array containing the Least Greater Elements for the above array will be [ 2, 6, 6, -1 ].

Input Format :
The first line of the input contains an integer, 'T,’ denoting the number of test cases.

The first line of each test case contains an integer 'N', denoting the number of elements in the array 'ARR'.

The second line of each test case contains 'N' space-separated integers denoting the array elements.

Output Format :
The only line of output of each test case should contain 'N' space-separated integers denoting the Least Greater element for each of the 'N' array elements.
Print the output of each test case in a new line.

Note :
You do not need to print anything. It has already been taken care of. Just implement the given function.

Constraints :
1 <= T <= 10
1 <= N <= 10^4
0 <= ARR[i]  <= 10^9
Where 'T' denotes the number of test cases, 'N' denotes the elements in the array 'ARR', and 'ARR[i]' denotes the 'i'th' element of the array 'ARR'.
Time Limit: 1 sec

Sample Input 1 :
2
4
5 6 7 2
3 
4 3 6
Sample Output 1 :
6 7 -1 -1 
6 6 -1
Explanation For Sample Input 1 :
For the first test case : 
1) For ARR [0] = 5, the least greater element is 6.
2) For ARR [1] = 6, the least greater element is 7.
3) For ARR [2] = 7, no least greater element exists. Hence, we will consider -1 here.
4) For ARR [3] = 2, no least greater element exists. Hence, we will consider -1 here.
Therefore, the output array is [ 6, 7, -1, -1 ] in this case.

For the second test case : 
1) For ARR [0] = 4, the least greater element is 6.
2) For ARR [1] = 3, the least greater element is 6.
3) For ARR [2] = 6, no least greater element exists. Hence, we will consider -1 here.
Therefore, the output array is [ 6, 6, -1 ] in this case.

Sample Input 2 :
2
3
6 2 6
4
5 6 1 4
Sample Output 2 :
-1 6 -1
6 -1 4 -1

*/


// O(n^2), O(1)
// other approach using bst -> O(n^2), O(n)
public class Solution {
    public static int[] leastGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int smallest = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            smallest = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    smallest = Math.min(smallest, arr[j]);
                    ans[i] = smallest;
                }
            }
            if (ans[i] == 0)
                ans[i] = -1;
        }
        
        return ans;
    }
}
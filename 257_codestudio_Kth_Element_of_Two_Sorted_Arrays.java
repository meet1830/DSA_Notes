/* 
 * Kth Element of Two Sorted Arrays
Ninja wants to serve food to needy people. So, he bought Ladoos from a sweet shop and placed them on plates. There can be any number of Ladoos present in a plate.
Plates containing Ladoos are placed in two rows. Each row is sorted in increasing order by the number of Ladoos in a plate.

For Example :
‘ROW1’ :  [2, 5, 8, 17] and  ‘ROW2’ :  [1, 4, 8, 13, 20]
Now people come one by one in a line to take plates of Ladoos from Ninja. Ninja picks the two plates in front, one from each row and gives that plate to people in which the number of ladoos is the smallest (if both plates contain equal numbers of ladoos then he serves any plate from the two plates) and places the other plate back to its position.

For Example :
If ‘ROW1’ is [2, 5, 8, 17] and ‘ROW2’ is [1, 4, 8, 13, 20], then Ninja picks the first plates from each rows, plate containing 2 ladoos from ‘ROW1’ and a plate containing 1 ladoo from ‘ROW2’. 
Then he gives the plate with 1 Ladoo to the first person in line and places the other plate back to its position.
Can you tell how many ladoos the ‘K'th’ person will get?

Input Format :
The first line of input contains an integer 'T' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case contains three single space-separated integers ‘N’,  ‘M’ and ‘K’ where ‘N’ and ‘M’ denote the number of plates containing ladoos in ‘ROW1’ and ‘ROW2’  respectively and ‘K’ denotes the ‘K’th’ person in line waiting to be served.

The second line of each test case contains ‘N’ single space-separated integers, denoting the number of ladoos in each plate of the first row i.e. ‘ROW1’.

The third line of each test case contains ‘M’ single space-separated integers, denoting the number of ladoos in each plate of the second row i.e. ‘ROW2’.
Output Format :
For each test case, print an integer denoting the number of ladoos the K'th person will get.

Print the output of each test case in a separate line.

Note :
You do not need to print anything; it has already been taken care of. Just implement the given function.

Constraints :
1 <= T <= 100
1 <= N, M, K <= 10^5
K <= (N + M)
0 <= ROW1[i], ROW2[i] <= 10^5

where ROW1[i] and ROW2[i] denote the number of Ladoos in i’th plates of ROW1 and ROW2 respectively.

Time Limit: 1 second

Sample Input 1 :
2
5 4 3
3 11 23 45 52
4 12 14 18
1 1 2
1
2
Sample Output 1 :
11
 2
Explanation For Sample Output 1 :
For sample test case 1: 
1’st person will get 3 ladoos i.e a minimum of 3 and 4. Now  ‘ROW1’ :  [11, 23, 45, 52] and  ‘ROW2’ :  [4, 12, 14, 18].
2’nd person will get 4 ladoos i.e minimum of 11 and 4. Now  ‘ROW1’ :  [11, 23, 45, 52] and  ‘ROW2’ :  [12, 14, 18].
3’rd person will get 11 ladoos i.e minimum of 11 and 12. 

For sample test case 2: 
1’st person will get 1 ladoos i.e a minimum of 1 and 2. Now  ‘ROW1’ :  [ ] and  ‘ROW2’ :  [2].
2’st person will get 2 ladoos because we have only one element left in ROW2 . Now  ‘ROW1’ :  [] and  ‘ROW2’ :  [].

Sample Input 2 :
2
5 3
1 3 6 7 10
3 5 5 7
3 3 2
10 20 20
1 2 3 
Sample Output 2 :
3 
2
Explanation For Sample Output 2 :
For sample test case 1: 
1’st person will get 1 ladoo i.e minimum of 1 and 3. Now  ‘ROW1’ :  [3, 7, 10] and  ‘ROW2’ :  [3, 5, 5, 7].
2’nd person will get 3 ladoos i.e now from both rows we will get a plate of 3 ladoos so Ninja can give any one plate containing ladoos from each row. Let us assume Ninja give a plate from ‘ROW2’. Now  ‘ROW1’ :  [3, 7, 10] and  ‘ROW2’ :  [5, 5, 7].
3’rd person will get 3 ladoos i.e minimum of 3 and 5. Now  ‘ROW1’ :  [7, 10] and  ‘ROW2’ :  [5, 5, 7].

For sample test case 2: 
1’st person will get 1 ladoo i.e minimum of 10 and 1. Now  ‘ROW1’ :  [10, 20, 30] and  ‘ROW2’ :  [ 2, 3].
2’nd person will get 2 ladoos i.e  minimum of 10 and 2. Now  ‘ROW1’ :  [10, 20, 30] and  ‘ROW2’ :  [3].
*/



/* gfg K-th element of two sorted Arrays
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthElement() which takes the arrays arr1[], arr2[], its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))


Constraints:
1 <= N, M <= 10^6
1 <= arr1i, arr2i < INT_MAX
1 <= K <= N+M
*/


// brute -> merge both the arrays and maintain a count variable. If the count variable equals to k, then return that element
// O(k), O(1)
// will give tle
public class Solution {
    public static int ninjaAndLadoos(int arr1[], int arr2[], int m, int n, int k) {
        int i = 0, j = 0, count = 0, ans = 0;
        
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                ans = arr1[i];
                i++;
            }
            else {
                ans = arr2[j];
                j++;
            }
            count++;
            if (count == k) 
                return ans;
        }
        if (i < m) 
            return ans = arr1[k - count];
        else 
            return ans = arr2[k - count];
    }
}



// optimal -> binary search -> creating partitions of size k
// O(log(minimum of m and n)), O(1)

public class Solution {
    public static int ninjaAndLadoos(int arr1[], int arr2[], int n, int m, int k) {
        if (m < n)
            return ninjaAndLadoos(arr2, arr1, m, n, k);
        
        // for edge cases
        int lo = Math.max(0, k - m), hi = Math.min(k, n);
        
        while (lo <= hi) {
            int cut1 = lo + (hi - lo) / 2;
            int cut2 = k - cut1;
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];
            
            if (l1 <= r2 && l2 <= r1) 
                return Math.max(l1, l2);
            else if (l1 > r2) 
                hi = cut1 - 1;
            else 
                lo = cut1 + 1; 
        }
        
        return -1;
    }
}

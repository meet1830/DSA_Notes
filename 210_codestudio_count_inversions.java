/* 
 * Count Inversions
For a given integer array/list 'ARR' of size 'N' containing all distinct values, find the total number of 'Inversions' that may exist.
An inversion is defined for a pair of integers in the array/list when the following two conditions are met.
A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

1. 'ARR[i] > 'ARR[j]' 
2. 'i' < 'j'

Where 'i' and 'j' denote the indices ranging from [0, 'N').

Input Format :
The first line of input contains an integer 'N', denoting the size of the array.

The second line of input contains 'N' integers separated by a single space, denoting the elements of the array 'ARR'.

Output Format :
Print a single line containing a single integer that denotes the total count of inversions in the input array.

Constraints :
1 <= N <= 10^5 
1 <= ARR[i] <= 10^9

Where 'ARR[i]' denotes the array element at 'ith' index.

Time Limit: 1 sec

Sample Input 1 :
3
3 2 1
Sample Output 1 :
3
Explanation Of Sample Output 1:
We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).

Sample Input 2 :
5
2 5 1 3 4
Sample Output 2 :
4
Explanation Of Sample Output 1:
We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).
*/


import java.util.* ;
import java.io.*; 

// brute -> use two for loops and count the number of inversions
// optimal -> use merge sort to count inversions while comparing elements. both the arrays are sorted while merging. hence if an element in left subarray is bigger then have to count all the elements of that subarray as both arrays are sorted and it will form an inversion pair. 

public class Solution {
    public static long merge(long[] arr, int l, int r, int m) {
        long count = 0;
        int sizeL = m - l + 1;
        int sizeR = r - m;
        long[] left = new long[sizeL];
        long[] right = new long[sizeR];
        
        for (int i = 0; i < sizeL; i++) 
            left[i] = arr[l + i];
        
        for (int i = 0; i < sizeR; i++)
            right[i] = arr[m + 1 + i];
        
        int i = 0, j = 0, k = l;
        while (i < sizeL && j < sizeR) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            
            else {
                arr[k++] = right[j++];
                count += (m - i);
            }
        }
        
        while (i < sizeL) 
            arr[k++] = left[i++];
        
        while (j < sizeR) 
            arr[k++] = right[j++];
        
        return count;
    }
    public static long mergeSort(long[] arr, int l, int r) {
        long count = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            count += mergeSort(arr, l, mid);
            count += mergeSort(arr, mid + 1, r);
            count += merge(arr, l, r, mid);
        }
        return count;
    }
    public static long getInversions(long arr[], int n) {
        long[] copy = arr;
        long count = mergeSort(copy, 0, n - 1);
        return count;
    }
}
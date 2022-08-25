/* 
 * Move all negative elements to end

Given an unsorted array arr[] of size N having both negative and positive integers. The task is place all negative element at the end of array without changing the order of positive element and negative element.

Example 1:
Input : 
N = 8
arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
Output : 
1  3  2  11  6  -1  -7  -5

Example 2:
Input : 
N=8
arr[] = {-5, 7, -3, -4, 9, 10, -1, 11}
Output :
7  9  10  11  -5  -3  -4  -1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function segregateElements() which takes the array arr[] and its size N as inputs and store the answer in the array arr[] itself.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 10^5
-10^5 ≤ arr[] ≤ 10^5

*/



// using extra space
// O(n), O(n)

class Solution {
    public void segregateElements(int[] a, int n) {
        int[] temp = new int[n];
        int p = 0;
        
        // copy pos elements to temp
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0)
                temp[p++] = a[i];
        }
        
        // copy neg elements to temp
        for (int i = 0; i < n; i++) {
            if (p < n && a[i] < 0)
                temp[p++] = a[i];
        }
        
        // replace temp array with input array
        for (int i = 0; i < n; i++) {
            a[i] = temp[i];
        }
    }
}



// O(logn), O(nlogn)

class Solution {
    private void merge(int[] arr, int l, int mid, int r) {
        int sl = mid - l + 1;
        int sr = r - mid;
        
        int[] left = new int[sl];
        int[] right = new int[sr];
        
        // copy data to temp array
        for (int i = 0; i < sl; i++) 
            left[i] = arr[i + l];
        for (int i = 0; i < sr; i++)
            right[i] = arr[i + mid + 1];
            
        // merge back temp arrays into arr
        int i = 0, j = 0, k = l;
        
        // copy pos elements from left
        while (i < sl && left[i] > 0)
            arr[k++] = left[i++];
            
        // copy pos elements from right
        while (j < sr && right[j] > 0)
            arr[k++] = right[j++];
            
        // copy neg elements from left
        while (i < sl)
            arr[k++] = left[i++];
            
        // copy neg elements from right
        while (j < sr)
            arr[k++] = right[j++];
    }
    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
            
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    public void segregateElements(int arr[], int n)
    {
        mergeSort(arr, 0, n - 1);
    }
}

/* 
 * Arranging the array

You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before positive numbers.(Maintain the order of all -ve and +ve numbers as given in the original array).
 
Example 1:
Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and positive numbers are 3, 2. 

Example 2:
Input:
N = 5
Arr[] = {2, -4, 7, -3, 4}
Output:
-4 -3 2 7 4
 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function Rearrange() which takes the array Arr[] and its size N as inputs and returns the array after rearranging with spaces between the elements of the array.

Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(Log(N))

Constraints:
1 ≤ N ≤ 10^7
-10^18 ≤ Elements of array ≤ 10^18

*/



// using extra space O(n), O(n)

class Compute {
    public void Rearrange(long a[], long n)
    {
        long[] temp = new long[(int)n];
        int p = 0;
        
        // copy neg elements to temp
        for (int i = 0; i < n; i++) {
            if (a[i] < 0)
                temp[p++] = a[i];
        }
        
        // copy pos elements to temp
        for (int i = 0; i < n; i++) {
            if (p < n && a[i] >= 0)
                temp[p++] = a[i];
        }
        
        // replace temp array with input array
        for (int i = 0; i < n; i++) {
            a[i] = temp[i];
        }
    }
}



// two pointers O(n), O(1) -> if order of elements is not considered

class Compute {
    private void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void Rearrange(long a[], long n)
    {
        int i = 0, j = (int)n - 1;
        while (i < j) {
            if (a[i] >= 0 && a[j] >= 0)
                j--;
            else if (a[i] >= 0 && a[j] < 0) 
                swap(a, i++, j);
            else {
                i++; j--;
            }
        }
    }
}



// sliding window + two pointer
// space efficient
// O(n * window size), O(1)

class Compute {
    private void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void Rearrange(long a[], long n)
    {
        int i = 0, j = 0;
        while (j < a.length) {
            if (a[j] >= 0)
                j++;
            else {
                for (int k = j; k > i; k--)
                    swap(a, k, k - 1);
                    
                i++; j++;
            }
        }
    }
}



// using merge sort
// merging in such a way that the neg part is merged first and then the pos part
// O(logn), O(nlogn)

class Compute {
    private void merge(long[] arr, int l, int mid, int r) {
        int sl = mid - l + 1;
        int sr = r - mid;
        
        long[] left = new long[sl];
        long[] right = new long[sr];
        
        // copy data to temp array
        for (int i = 0; i < sl; i++) 
            left[i] = arr[i + l];
        for (int i = 0; i < sr; i++)
            right[i] = arr[i + mid + 1];
            
        // merge back temp arrays into arr
        int i = 0, j = 0, k = l;
        
        // copy neg elements from left
        while (i < sl && left[i] < 0)
            arr[k++] = left[i++];
            
        // copy neg elements from right
        while (j < sr && right[j] < 0)
            arr[k++] = right[j++];
            
        // copy pos elements from left
        while (i < sl)
            arr[k++] = left[i++];
            
        // copy pos elements from right
        while (j < sr)
            arr[k++] = right[j++];
    }
    private void mergeSort(long[] arr, int l, int r) {
        if (l >= r)
            return;
            
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    public void Rearrange(long a[], long n)
    {
        mergeSort(a, 0, (int)n - 1);
    }
}



// using merge sort using constant space
// Lp - left pos, Ln - left neg, Rn, Rp
// Reverse Lp and Rn -> [Ln Lp Rn Rp] -> [Ln Lp’ Rn’ Rp]
// Reverse [Lp’ Rn’] -> [Ln Lp’ Rn’ Rp] -> [Ln Rn Lp Rp]
// O(nLogn), O(logn) -> stack space for recursive calls
class Compute {
    private void swap(long[] arr, int i, int j)
    {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(long arr[], int l, int r)
    {
        if (l < r) {
            swap(arr, l, r);
            reverse(arr, ++l, --r);
        }
    }
    private void merge(long[] arr, int l, int m, int r) {
        int i = l; // Initial index of 1st subarray
        int j = m + 1; // Initial index of IInd
 
        // reach till Lp
        while (i <= m && arr[i] < 0)
            i++;
 
        // reach till Rp
        while (j <= r && arr[j] < 0)
            j++;
 
        // reverse positive part of left
        reverse(arr, i, m);
 
        // reverse negative part of right
        reverse(arr, m + 1, j - 1);
 
        // reverse arr[i..j-1]
        reverse(arr, i, j - 1);
    }
    private void mergeSort(long[] arr, int l, int r) {
        if (l >= r)
            return;
            
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    public void Rearrange(long a[], long n)
    {
        mergeSort(a, 0, (int)n - 1);
    }
}
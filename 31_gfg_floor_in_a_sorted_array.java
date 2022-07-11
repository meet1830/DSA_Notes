/*
Floor in a Sorted Array

Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

Example 1:
Input:
N = 7, x = 0 
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less than 0 
is found. So output is "-1".

Example 2:
Input:
N = 7, x = 5 
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is
2 (i.e K = 2), whose index is 1(0-based indexing).

Your Task:
The task is to complete the function findFloor() which returns an integer denoting the index value of K or return -1 if there isn't any such number.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]
*/

class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int l = 0, r = n - 1, result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                result = mid;
                return result;
            }
            if (arr[mid] < x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}

// for finding ceil same code as above with
// following changes in while loop

/*
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
*/

// APPROACH - FUNDAMENTAL AND SIMPLE
// At the end of a binary search (if not terminated early), that is after terminating the loop due to violation of condition first pointer points to the ceil of target and second points to the floor. 

public class Main {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3 ,4 ,5 ,8 ,10};
        int target = 8;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == target) {
                System.out.println("Floor and Ceil same as target: " + arr[mid]);
                return;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        System.out.println("Floor: " + arr[r]);
        System.out.println("Ceil: " + arr[l]);
    }
}

// -> Similar question - minimum difference element
// -> Problem statement
// In this question, we have to find the element in the given sorted array which has the minimum difference when subtracted from the target element given, which may or may not exist in the array.
// -> Approach
// Here upon looking, we know that if the array has the target element in it then it is only ans possible, difference is zero. But if not present, then we need to find the neighbour elements and find difference, and return the elements with minimum difference. The neighbouring elements are actually the floor and ceil of the target value and can be found out using the above fundamental approach. 

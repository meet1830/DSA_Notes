/*
Problem statement:
Find indices of first and second largest element in array
*/

// if -> else if not written than will fail for testcase where array in descending order and x != max for duplicates
public class Main {
    public static void main(String[] args) {
        int[] arr = {5,5,4,3,2,1};
        int max = -1, secmax = -1;
        for (int x : arr) {
            if (x > max) {
                secmax = max;
                max = x;
            } 
            else if (x > secmax && x != max)
                secmax = x;
        } 
        System.out.println(max + " " + secmax);
    }
}


// more efficient approach

import java.util.Scanner;
public class MyClass {
    public static int bsearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (target > arr[mid]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = input.nextInt();
        }
        int first = Integer.MIN_VALUE, fIndex = -1,
        second = Integer.MIN_VALUE, sIndex = -1;
        for (int i=0; i<n; i++) {
            // if current element is greater than first
            // then update both elements
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }
            
            // if current element if between first and
            // second then update second
            if (arr[i] < first && arr[i] > second) {
                second = arr[i];
            }
        }
        //find indices
        fIndex = bsearch(arr, first);
        sIndex = bsearch(arr, second);
        System.out.println(fIndex + " " + sIndex);
    }
}

// if space complexity is not an issue then use an arraylist, find largest element 2 times after removing the largest element for the second time.

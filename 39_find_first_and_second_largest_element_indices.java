/*
Problem statement:
Find indices of first and second largest element in array
*/

// more efficient if want to find indices of first and second largest elements
import java.util.Scanner;
public class P1_find_first_and_second_largest_element_indices {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int max = Integer.MIN_VALUE, maxIndex = -1;
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = input.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            } 
        }
        int secMax = 0, secMaxIndex = -1;
        for (int i=0; i<n; i++) {
            if (arr[i] != max) {
                secMax = Math.max(secMax, arr[i]);
            }
        }
        for (int i=0; i<n; i++) {
            if (arr[i] == secMax) {
                secMaxIndex = i;
                break;
            }
        }
        System.out.println(maxIndex + " " + secMaxIndex);
    }
}


// more efficient approach if want to just find the value of first and second largest elements

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

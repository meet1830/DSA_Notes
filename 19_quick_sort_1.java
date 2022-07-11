/*
Quick Sort 1
The previous challenges covered , which is a simple and intuitive sorting algorithm with a running time of (On^2) . In these next few challenges, we are covering a divide-and-conquer algorithm called (also known as Partition Sort). This challenge is a modified version of the algorithm that only addresses partitioning. It is implemented as follows:

Step 1: Divide
Choose some pivot element,p , and partition your unsorted array, arr , into three smaller arrays: left , right , and equal , where each element in left <p , each element in right <p , and each element in equal =p .

Example
arr= [5,7,4,3,8] In this challenge, the pivot will always be at arr[0] , so the pivot is 5 .

arr is divided into left ={4,3} , equal={5} , and right ={7,8} .
Putting them all together, you get [4,3,5,7,8] . There is a flexible checker that allows the elements of left and right to be in any order. For example,[3,4,5,8,7] is valid as well.

Given arr and p=arr[0] , partition arr into left , right , and equal using the Divide instructions above. Return a 1-dimensional array containing each element in left first, followed by each element in equal , followed by each element in right .

Function Description

Complete the quickSort function in the editor below.

quickSort has the following parameter(s):

_int arr[n]:_arr[0] is the pivot element
Returns

int[n]: an array of integers as described above
Input Format

The first line contains n , the size of arr .
The second line contains n space-separated integers arr(i) (the unsorted array). The first integer, arr[0] , is the pivot element, p .

Constraints 1 <= n <= 1000

-1000 <= arr[i] <= 1000 where 0 <=i <n
All elements are distinct.
Sample Input

STDIN Function

5 arr[] size n =5 4 5 3 7 2 arr =[4, 5, 3, 7, 2]

Sample Output

3 2 4 5 7

Explanation

arr=[4,5,3,7,2]Pivot:p=arr[0]=4 .
left={};equal={4};right={};

arr[1]=5>p, so it is added to right .
left={};equal={4};right={};

arr[2]=3<p, so it is added to left .
left={3};equal={4};right={5};

arr[3]=7>p, so it is added to right .
left={3};equal={4};right={5,7};

arr[4 ]=2<p, so it is added to left .
left={3,2};equal={4};right={5,7};

Return the array {32457} .

The order of the elements to the left and right of 4 needs to match this answer as well.
*/

import java.util.Scanner;

public class A2_quick_sort_1 {
  public static void main (String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] arr = new int[n];
    int[] result = new int[n];
    int pivot = input.nextInt();
    int j = 0, count = 1;
    for (int i=1; i<n; i++) {
      arr[i] = input.nextInt();
      if (arr[i]<pivot) {
        result[j++] = arr[i];
      }
      else if (arr[i] == pivot) {
        count++;
      }
    }
    for (int i=0; i<count; i++) {
      result[j++] = pivot;
    }
    for (int i=1; i<n; i++) {
      if (arr[i] > pivot) {
        result[j++] = arr[i];
      }
    }
    for (int x : result) {
      System.out.print(x + " ");
    }
    System.out.println(" ");
  }
}

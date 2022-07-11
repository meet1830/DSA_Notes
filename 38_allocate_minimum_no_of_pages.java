/*
Allocate minimum number of pages

You are given N number of books. Every ith book has Ai number of pages. You have to allocate contagious books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book

Input
First line contains a two integers N denoting number of books and M number of students Second Line contains N integers where ith integer denotes number pages in ith book

Output
Print value of minimum of maximum number of pages allocated ot student

Constraints:
1 <= N <= 100000 1 <= A[i] <= 1000000 1 <= M <= 100000

Sample Input:
4 2
12 34 67 90

Sample Output:
113

Explaination:
Allocation can be done in following ways: 
{12} and {34, 67, 90} Maximum Pages = 191 
{12, 34} and {67, 90} Maximum Pages = 157 
{12, 34, 67} and {90} Maximum Pages = 113 
Therefore, the minimum of these cases is 113, which is selected as the output.
*/

// Refer binary search youtube playlist of Aditya Verma - Allocate minimum number of pages

import java.util.*;
import java.io.*;

public class Main {
  public static boolean isValid (int[] arr, int n, int m, int mid) {
    int students = 1, sum = 0;
    for (int i=0; i<n; i++) {
      sum += arr[i];
      if (sum > mid) {
        students++;
        sum = arr[i];
      }
      if (students > m) {
        return false;
      }
    }
    return true;
  }
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();

    // each student should get 
    // at least one book
    if (n < m) {
      System.out.println(-1);
      return;
    }
    
    int[] pages = new int[n];
    
    // taking array input, finding max 
    // in array and taking 
    // sum of every element
    // l = max ele in array
    // r = sum of ele in array
    int l = 0, r = 0;
    for (int i=0; i<n; i++) {
      pages[i] = input.nextInt();
      if (i > 0) {
        if (pages[i] > pages[i - 1]) {
          l = pages[i];
        }
      }
      r += pages[i];
    }

    int res = -1;
    
    while (l <= r) {
      int mid = l + (r-l)/2;
      if (isValid(pages, n, m, mid) == true) {
        res = mid;
        r = mid - 1;
      }
      else {
        l = mid + 1;
      }
    }
    System.out.println(res);
  }
}

// Can start from zero and not max, but the best starting case will be to allocate maximum pages to one student and all other pages to the other one asssuming total two students.




/*
Geeks for geeks same question: https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1# 

Allocate minimum number of pages 

You are given N number of books. Every ith book has Ai number of pages.

You have to allocate contagious books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is the minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Example 1:
Input:
N = 4
A[] = {12,34,67,90}
M = 2

Output:113

Explanation:Allocation can be done in 
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages = 113. 
Therefore, the minimum of these cases is 113, which is selected as the output.

Example 2:
Input:
N = 3
A[] = {15,17,20}
M = 2

Output:32

Explanation: Allocation is done as
{15,17} and {20}

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.

Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= A [ i ] <= 106
1 <= M <= 105
*/

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[] arr, int n, int m)
    {
        
        // base case: each student should be allocated at least one book
        if (n < m) {
            return -1;
        }
        
        // finding max from the input array and sum of each element
        // l = max, r = sum
        int l = 0, r = arr[0];
        for (int i=1; i<n; i++) {
            if (arr[i-1] < arr[i]) {
                l = arr[i];
            }
            r += arr[i];
        }
        
        int res = -1;
        // apply binary search
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (isValid(arr, n, m, mid) == true) {
                res = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return res;
    }
    
    // function to calculate number of students
    public static boolean isValid (int[] arr, int n, int m, int mid) {
        int students = 1, sum = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];
            if (sum > mid) {
                students++;
                sum = arr[i];
            }
            if (students > m) {
                return false;
            }
        }
        return true;
    }
};

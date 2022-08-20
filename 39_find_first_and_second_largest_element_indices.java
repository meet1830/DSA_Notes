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


/*
CodeStudio - Second largest element in the array 
Question:
You have been given an array/list 'ARR' of integers. Your task is to find the second largest element present in the 'ARR'.
Note:
a) Duplicate elements may be present.
b) If no such element is present return -1.

Example:
Input: Given a sequence of five numbers 2, 4, 5, 6, 8.
Output:  6

Explanation:
In the given sequence of numbers, number 8 is the largest element, followed by number 6 which is the second-largest element. Hence we return number 6 which is the second-largest element in the sequence.

Input Format:
The first line of input contains an integer ‘T’ denoting the number of test cases. 
The next ‘2*T’ lines represent the ‘T’ test cases.
The first line of each test case contains an integer ‘N’ denoting the number of elements in the array.
The second line of each test case contains ‘N’ space-separated integers denoting the elements in the array. 

Output Format:
For each test case, print a single line containing a single integer denoting the second largest element in the array.
The output of each test case will be printed in a separate line.

Note:
You are not required to print the expected output; it has already been taken care of, Just implement the function.

Constraints:
1 <= T <= 100
1 <= N <= 5000
-10 ^ 9 <= 'SIZE' <= 10 ^ 9 
Where ‘T’ is the total number of test cases, ‘N’ denotes the number of elements in the array and ‘SIZE’ denotes the range of the elements in the array.
Time limit: 1 sec.

Sample Input 1:
2
6
12 1 35 10 34 1
5
10 10 10 10 10
Sample Output 1:
34
-1
Explanation Of Sample Input 1:
Test case 1: In the given sequence of numbers, number 35 is the largest element, followed by number 34 which is the second-largest element. Hence we return number 34 which is the second-largest element in the sequence.
Test case 2: In the given sequence of numbers, number 10 is the largest element. However, since all the elements are the same, the second largest element does not exist. So, we return -1.

Sample Input 2:
1
6
7 8 8 1 4 3 
Sample Output 2:
7
Explanation Of Sample Input 2:
In the given sequence of numbers, 8 exists two times and is the largest element, followed by 7 which is the second-largest element. Hence we return the number 7 as the second-largest element.
*/


public class Solution {
	public static int findSecondLargest(int n, int[] arr) {
        if (n == 1) {
            return arr[0];
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            first = Math.max(first, arr[i]);
        }
        for(int i = 0; i < n; i++) {
            if (arr[i] != first) {
                second = Math.max(second, arr[i]);
            }
        }
        if (second == Integer.MIN_VALUE) {
            second = -1;
        }
        return second;
 	} 
}



// in one loop more efficient
public class Solution {
	public static int findSecondLargest(int n, int[] arr) {

		int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {

			// Find largest and second largest element simultaneously.
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			}

			// If an element is smaller than largest and larger than second largest.
			else if (arr[i] > secondLargest && arr[i] != largest) {
				secondLargest = arr[i];
			}
		}

		if (secondLargest != Integer.MIN_VALUE) {
			return secondLargest;
		} else {
			return -1;
		}
	}
}


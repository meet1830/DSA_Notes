/*
Target Sum Subsets

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. Complete the body of printTargetSumSubsets function - without changing signature - to calculate and print all subsets of given elements, the contents of which sum to "tar". Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50

Format
Input
Input Format
A number n
n1
n2
.. n number of elements
A number tar

Output
Comma separated elements of the subset, the contents of which add to "tar"
.. all such subsets, each in a single line (the elements of each subset should be comma separated)

Example
Sample Input
5
10
20
30
40
50
60

Sample Output
10, 20, 30, .
10, 50, .
20, 40, .
*/

public class Main {
  public static void printSumSubsets(int[] arr, int idx, String set, int sum, int target) {
    // base
    if (idx == arr.length) {
      if (sum == target) {
        System.out.println(set + ".");
      }
      return;
    }
    
    // pick - include
    printSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sum + arr[idx], target);
    
    // not pick - not include
    printSumSubsets(arr, idx + 1, set, sum, target);
  }
  public static void main(String args[]) {
    int[] arr = {10, 20, 30, 40, 50};
    int target = 60;
    printSumSubsets(arr, 0, "", 0, target);
  }
}

/*
10, 20, 30, .
10, 50, .
20, 40, .
*/

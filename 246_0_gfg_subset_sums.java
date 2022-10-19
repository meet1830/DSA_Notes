/* gfg subset sums
 * Given a list arr of N integers, print sums of all subsets in it.

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.

Example 2:

Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8
Your Task:  
You don't need to read input or print anything. Your task is to complete the function subsetSums() which takes a list/vector and an integer N as an input parameter and return the list/vector of all the subset sums.

Expected Time Complexity: O(2N)
Expected Auxiliary Space: O(2N)

Constraints:
1 <= N <= 15
0 <= arr[i] <= 10^4
 */


// number of subsets of N size array -> 2^N (limit)
// from 0, 1, 2 .. limit - 1 every interger can be represented by binary number
// for example if length 2 then 4 subsets = limit
// 0,0 - 0,1 - 1,0 - 1,1 (from 0 to limit - 1 = 3)
// and if array is 8,9 then subsets can be written as
// _,_ - _,9 - 8,_ - 8,9
// hence subsets can match same as binary numbers
// keep finding binary number if remainder is 1 then add that to sum or hence ignore
// and keep adding to ans arraylist
// O(2^n), O(1) -> not counting ans data structure space

class Solution {
  ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
      ArrayList<Integer> ans = new ArrayList<>();
      
      int limit = (int)Math.pow(2, N);
      
      for (int i = 0; i < limit; i++) {
          int sum = 0;
          int temp = i;
          
          // getting binary and determing sum
          for (int j = N - 1; j >= 0; j--) {
              if (temp % 2 == 1) {
                  sum += arr.get(j);
              }
              temp /= 2;
          }
          
          ans.add(sum);
      }
      
      return ans;
  }
}



// using recursion concept or pick and not pick
// if returning array then need to sort for ans to match
// O(2^N), O(1)

class Solution {
  void findSum(int idx, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ans) {
      // base case to stop recursion
      if (idx == N) {
          ans.add(sum);
          return;
      }
          
      // pick
      findSum(idx + 1, sum + arr.get(idx), arr, N, ans);
      
      // not pick
      findSum(idx + 1, sum, arr, N, ans);
  }
  ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
      ArrayList<Integer> ans = new ArrayList<>();
      findSum(0, 0, arr, N, ans);
      // Collections.sort(ans);
      return ans;
  }
}


class Solution {
  private void findSub(ArrayList<Integer> arr, int idx, int sum, ArrayList<Integer> ans) {
    ans.add(sum);
    for (int i = idx; i < arr.size(); i++) {
      sum += arr.get(i);
      findSub(arr, i + 1, sum, ans);
      sum -= arr.get(i);
    }
  }
  ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
    ArrayList<Integer> ans = new ArrayList<>();
    findSub(arr, 0, 0, ans);
    return ans;
  }
}



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




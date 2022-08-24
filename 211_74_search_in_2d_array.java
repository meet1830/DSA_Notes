/*
Codestudio
Search In A Row Wise And Column Wise Sorted Matrix

Problem Statement
You are given an N * N matrix of integers where each row and each column is sorted in increasing order. You are given a target integer 'X'. Find the position of 'X' in the matrix, if it exists then return the pair {i, j} where 'i' represents the row and 'j' represents the column of the array, otherwise return {-1,-1}

For example: If the given matrix is:
[ [1, 2, 5],
  [3, 4, 9],
  [6, 7, 10]] 
We have to find the position of 4. We will return {1,1} since A[1][1] = 4.

Input Format:
The first line of input contains a single integer 'T', representing the number of test cases or queries to be run. 
Then the 'T' test cases follow.
The first line of each test case contains two space-separated integers 'N' and 'X', representing the size of the matrix and the target element respectively.
Each of the next 'N' lines contains 'N' space-separated integers representing the elements of the matrix.

Output Format:
For each test case, print the position of 'X', if it exists, otherwise print “-1 -1”.

Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 10^3
1 ≤ X ≤ 10^6
1 ≤ Aij ≤ 10^6
where 'T' is the number of test cases, 'N' is the number of rows and columns, 'X' is the target value, and Aij is the elements of the matrix.

Time Limit : 1 sec 

Note:
It is guaranteed that the matrix contains distinct elements.
You are not required to print the expected output, it has already been taken care of. Just implement the function.

Sample Input 1:
2
3 4
1 2 5
3 4 9
6 7 10
2 5
4 5
8 6

Sample Output 1:
1 1
0 1

Explanation Of Input 1:
The first test case is already explained in the problem statement.
The second test case,  the given matrix is:
[[4, 5],
 [5, 6]] 
We have to find the position of 5. So we return {0,1}.

Sample Input 2:
2
3 16
2 4 8
3 6 9
4 7 16
1 10
4

Sample Output 2
2 2
-1 -1
*/

/*************************************
 
    Following is the Pair Class structure.
    
    class Pair{
        int x; int y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

*************************************/

public class Solution {
	public static Pair search(int [][] matrix, int key) {
		int i = 0, j = matrix[0].length - 1;
        while (i>=0 && i<=matrix.length-1 && j>=0 && j<=matrix[0].length-1) {
            if (matrix[i][j] == key) {
                return new Pair(i, j); 
            }
            else if (matrix[i][j] > key) {
                j--;
            }
            else {
                i++;
            }
        }
        return new Pair(-1, -1);
	}
}

// same approach by returning array

public class Main {
    public static int[] searchMat(int m, int n, int[][] mat, int key) {
        int i = 0, j = n - 1;
        int[] result = {-1, -1};
        while (i>=0 && i<=m-1 && j>=0 && j<=n-1) {
            if (mat[i][j] == key) {
                result[0] = i;
                result[1] = j;
                return result;
            }
            else if (mat[i][j] > key) {
                j--;
            }
            else {
                i++;
            }
        }
        return result;
    }
    public static void main(String args[]) {
        int m = 4, n = 4;
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int key = 1;
        int[] result = searchMat(m, n, mat, key);
        System.out.println(result[0] + " " + result[1]);
    }
}



/* leetcode
 * 74. Search a 2D Matrix
Medium

9217

298

Add to List

Share
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4

*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i>=0 && i<=matrix.length-1 && j>=0 && j<=matrix[0].length-1) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
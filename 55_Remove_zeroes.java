/*
You are given a string s. Each character is either 0 or 1.

You want all 1s in the string to form a contiguous subsegment. For example, if the string is 0, 1, 00111 or 01111100, then all ones (1) form a contiguous subsegment, and if the string is 0101, 100001 or 11111111111101, then this condition is not met.

You may erase some (possibly none) zeroes(0) from the string. What is the minimum number of zeros (0) that you have to erase?

Input
The first line contains one integer t (1≤t≤100) — the number of test cases.

Then t lines follow, each representing a test case. Each line contains one string s (1≤|s|≤100); each character of s is either 0 or 1.

Output
Print t integers, where the i-th integer is the answer to the i-th testcase (the minimum number of zeros(0) that you have to erase from s).

Example
Input
3
010011
0
1111000

Output
2
0
0

Note
In the first test case you have to delete the third and forth symbols from string 010011 (it turns into 0111).
*/

import java.util.*;

public class G1_Remove_zeroes {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String[] arr = new String[n];
    int ttz = 0, pz = 0, tz = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = input.next();
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < arr[i].length(); j++) {
        if (arr[i].charAt(j) == '0')
          ttz++;
      }
      for (int k = 0; k < arr[i].length(); k++) {
        if (arr[i].charAt(k) != '1' && arr[i].length() != 1) {
          pz++;
        } else
          break;
      }
      for (int l = arr[i].length() - 1; l >= 0; l--) {
        if (arr[i].charAt(l) != '1') {
          tz++;
        } else
          break;
      }
      System.out.println(ttz - pz - tz);
      ttz = 0;
      pz = 0;
      tz = 0;
    }
    input.close();
  }
}

//can use while loops instead of for loops
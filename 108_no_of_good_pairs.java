/*
Number of good pairs
Given an array of integers nums, print the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Input:
The first line contains a two integers n(size of array n) and k Second line contains n spaced integers

Output:
Print number of good pairs

Constraints
1 <= nums.length <= 100
1 <= nums[i] <= 100
Sample Input 1
6 1 2 3 1 1 3

Sample Output 1
4

Explanation
There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Sample Input 2
4
1 1 1 1
Sample Output 2
6
*/

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }  
    int pairCount = 0;
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        if(arr[i] == arr[j]) {
          pairCount++;
        }
      }
    }
    System.out.println(pairCount);
  }
}

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] arr = new int[n];
    int[] freq = new int[101];
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
      freq[arr[i]]++;
    }
    long ans = 0;
    for (int i = 0; i < 101; i++) {
      if (freq[i] > 1) {
        ans += (long) freq[i] * (freq[i] - 1) / 2;
      }
    }
    System.out.println(ans);
  }
}


// hashmaps
public int numIdenticalPairs(int[] nums) {
  int pairCount = 0;
  Map<Integer, Integer> map = new HashMap<>();
  for (int n : nums) {
      // for the first occurrence of the element, set map value as 0
      ///increment for subsequent entries for the same element
      if(map.get(n) == null){
          map.put(n, 1);
      }else{
          map.put(n, map.get(n) + 1);
      }
      //short form for above if else block !
      // map.put(n, map.getOrDefault(n, 0) + 1);

      // additional pair can be formed btw n and all previous v == n;
      // so need to subtract 1 each time
      // sample input [1,2,3,1,1,3]
      // For example if there are two occurrence of element 3,
      // we can form only one pair (3,3)
      // But if we see a third occurrence, we can form two more pairs
      // so total 3 pairs (including the first pair)
      // so we need to subtract 1 every time, to get the correct number of pairs
      pairCount += map.get(n) - 1 ;
  }
  return pairCount;
}


// First we can count the frequency of each numbers using array. If a number appears n times, then n * (n - 1) / 2 pairs can be made with this number.

class Solution {
  public int numIdenticalPairs(int[] nums) {
    
    int ans = 0;
    int[] count = new int[101];
    
    for(int n: nums)
        count[n]++;
    
    for(int n: count)
        ans += (n * (n - 1))/2;
    
    return ans;
  }
}
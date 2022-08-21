/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 
Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/


import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String[] strs = new String[n];
    for (int i = 0; i < n; i++) {
      strs[i] = input.next();
    }
    input.close();
    List<List<String>> result = new ArrayList<>();
    result = groupAnagrams(strs);
    
    // OR
    //
    // List<List<String>> res = groupAnagrams(strs);
    // 
    // for(List<String> s : res) {
    //	for(String r : s) {
    //		System.out.print(r + " ");
    //	}
    //	System.out.println();
    // }
    
    System.out.println(result);
  }
  public static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, ArrayList<String>> hm = new HashMap<>();
    List<List<String>> result = new ArrayList<>();

    for (String x : strs) {
      char[] arr = x.toCharArray();
      Arrays.sort(arr);

      String sorted = new String(arr);

      if (hm.containsKey(sorted)) {
        ArrayList<String> list = hm.get(sorted);
        list.add(x);
        hm.put(sorted, list);
      } else {
        ArrayList<String> list = new ArrayList<>();
        list.add(x);
        hm.put(sorted, list);
      }
    }

    for (String s : hm.keySet()) {
      result.add(hm.get(s));
    }
    // for(ArrayList<String> x : hm.values()) {
    //   result.add(x);
    // }

    return result;
  }
}


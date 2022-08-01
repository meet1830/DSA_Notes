// Q1 -> print all subsequences whose sum of elements is equal to k
// is equal to print subsequences if in base condition added nested if condition and caluclated sum of subsequence and matched with sum then only print the value

import java.util.*;
public class P6_print_subsequences_whose_sum_is_k {
  public static void subsk(int[] arr, int index, ArrayList<Integer> sub, int sum, int s) {
    if (index == arr.length) {
      if (s == sum) {
        System.out.println(sub);
      }
      return;
    }
    sub.add(arr[index]);
    s += arr[index];
    subsk(arr,  index + 1, sub, sum, s);
    sub.remove(sub.size() - 1);
    s -= arr[index];
    subsk(arr,  index + 1, sub, sum, s);
  }
  public static void main(String[] args) {
    int[] arr = {1, 2, 1};
    ArrayList<Integer> sub = new ArrayList<>();
    int k = 2;
    subsk(arr, 0, sub, k, 0);    
  }
}
 
/*
[1, 1]
[2]
*/



// Q2 -> print any one subsequence of sum k
// technique of printing just one ans 
// if got ans, print it and no further recursion needs to be done

import java.util.*;
public class P6_print_subsequences_whose_sum_is_k {
  public static boolean subsk(int[] arr, int index, ArrayList<Integer> sub, int sum, int s) {
    if (index == arr.length) {
      // condition satisfied
      if (s == sum) {
        System.out.println(sub);
        return true;
      }
      // condition not satisfied
      return false;
    }
    sub.add(arr[index]);
    s += arr[index];
    if (subsk(arr,  index + 1, sub, sum, s)) {
      return true;
    }
    sub.remove(sub.size() - 1);
    s -= arr[index];
    if (subsk(arr,  index + 1, sub, sum, s)) {
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
    int[] arr = {1, 2, 1};
    ArrayList<Integer> sub = new ArrayList<>();
    int k = 2;
    subsk(arr, 0, sub, k, 0);    
  }
}

/*
[1, 1]
*/



// Q3 -> Count the number of subsequences with sum = k in the given array
// technique of counting the number of subsequences
// remove arraylist

public class P6_print_subsequences_whose_sum_is_k {
  public static int subsk(int[] arr, int index, int sum, int s) {

    // slight optimization in time complexity -> only if the array contains all POSITIVE elements
    if (s > sum) {
      return 0;
    }

    if (index == arr.length) {
      // condition satisfied
      if (s == sum) {
        return 1;
      }
      // condition not satisfied
      return 0;
    }
    s += arr[index];
    int l = subsk(arr,  index + 1, sum, s);
    s -= arr[index];
    int r = subsk(arr,  index + 1, sum, s);
    return l + r;
  }
  public static void main(String[] args) {
    int[] arr = {1, 2, 1};
    int k = 2;
    System.out.println(subsk(arr, 0, k, 0));   
  }
}

// output -> 2

// Time complexity O(2^n)

// reverse array without recursion
public class MyClass {
    public static void swap (int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};
        int l = 0, r = arr.length - 1;
        while (l < r) {
            swap(arr, l++, r--);
        } 
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}


// reverse array using recursion using 2 pointers
public class MyClass {
    public static void swap (int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public static void reverse (int[] arr, int l, int r) {
        // base
        if (l >= r) {
            return;
        }
        swap(arr, l, r);
        reverse (arr, l+1, r-1);
    }
    public static void main (String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int l = 0, r = arr.length - 1;
        reverse(arr, l, r);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}


// reverse array using recursion using single pointer
public class MyClass {
    public static void swap (int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public static void reverse (int[] arr, int i, int n) {
        // base
        if (i >= n/2) {
            return;
        }
        swap(arr, i, n-i-1);
        reverse (arr, i + 1, n);
    }
    public static void main (String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        reverse(arr, 0, n);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// output -> 6 5 4 3 2 1



// SIMILAR QUESTION -> CHECK IF STRING IS PALINDROME
// Techie Delight 237 - Palindrome String
/*
Given a string, check if it is a palindrome. A palindromic string is a string that remains the same with its characters reversed.

Input : "ABCBA"
Output: true

Input : "ABCA"
Output: false
*/

class Solution
{
	public static boolean isPalindrome(String s)
	{
		return check (s, 0, s.length());
	}
	public static boolean check(String s, int i, int n) {
		// base
		if (i >= n/2) {
			return true;
		}
		if (s.charAt(i) != s.charAt(n-i-1)) {
			return false;
		}
		else {
			return check(s, i+1, n);
		}
	}
}

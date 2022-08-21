/*
Product of Array Except Self
Given an array of n integers where n > 1, print an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Input
line 1: contains an integer n denoting number of elements of array.

line 2: contains n separated integers denoting elements of array. All integers are greater than 0.

Output
print an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Constraints
It is guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Time Complexity:O(n)

Sample Input
4
4 3 2 10
Sample Output
60 80 120 24
*/

import java.util.Scanner;
public class G2_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        long prod = 1;
        for (int i=0; i<n; i++) {
            arr[i] = input.nextInt();
            prod *= arr[i];
        }
        for (int i=0; i<n; i++)
            System.out.println(prod/arr[i] + " ");
        input.close();
    }
}



class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // approach
        // prodexcepti[i] = prefixprod[i - 1] * suffixprod[i + 1]
        
        int n = nums.length;
        int[] ans = new int[n];
        int prod = 1;
        
        for(int i = 0; i < n; i++) {
            // prefix product
            prod *= nums[i];
            ans[i] = prod;
        }
        
        prod = 1;
        for(int i = n - 1; i > 0; i--) {
            ans[i] = ans[i - 1] * prod;
            prod *= nums[i];
        }
        
        ans[0] = prod;
        return ans;
    }
}



class Solution {

	public static int[] productExceptSelf(int a[])
	{
        int n = a.length;
        
		int prod = 1;
		int flag = 0;

		// product of all elements
		for (int i = 0; i < n; i++) {

			// counting number of elements
			// which have value
			// 0
			if (a[i] == 0)
				flag++;
			else
				prod *= a[i];
		}

		// creating a new array of size n
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {

			// if number of elements in
			// array with value 0
			// is more than 1 than each
			// value in new array
			// will be equal to 0
			if (flag > 1) {
				arr[i] = 0;
			}

			// if no element having value
			// 0 than we will
			// insert product/a[i] in new array
			else if (flag == 0)
				arr[i] = (prod / a[i]);

			// if 1 element of array having
			// value 0 than all
			// the elements except that index
			// value , will be
			// equal to 0
			else if (flag == 1 && a[i] != 0) {
				arr[i] = 0;
			}

			// if(flag == 1 && a[i] == 0)
			else
				arr[i] = prod;
		}
		return arr;
	}

	// Driver Code
// 	public static void main(String args[])
// 		throws IOException
// 	{
// 		int n = 5;
// 		int[] array = { 10, 3, 0, 6, 2 };

// 		Solution ob = new Solution();
// 		long[] ans = new long[n];
// 		ans = ob.productExceptSelf(array, n);

// 		for (int i = 0; i < n; i++) {
// 			System.out.print(ans[i] + " ");
// 		}
// 	}
}


class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] pp = new int[n], sp = new int[n];
        pp[0] = 1; 
        sp[n - 1] = 1;
        
        for(int i = 1; i < n; i++) pp[i] = pp[i - 1] * nums[i - 1];
        
        for(int i = n - 2; i >= 0; i--) sp[i] = sp[i + 1] * nums[i + 1];
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = pp[i] * sp[i];
        
        return ans;
    }
}


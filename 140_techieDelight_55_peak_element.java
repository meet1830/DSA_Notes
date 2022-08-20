/*
 * TechieDelight 55. Peak Element
Given an integer array `A`, find the peak element in it. An element `A[i]` is a peak element if it's greater than its neighbour(s). i.e.,

• A[i-1] <= A[i] >= A[i+1]	(for 0 < i < n-1)
• A[i-1] <= A[i]			(if i = n – 1)
• A[i] >= A[i+1]			(if i = 0)


Input: [8, 9, 10, 12, 15]
Output: 15

Input: [10, 8, 6, 5, 3, 2]
Output: 10

• There might be multiple peak elements in an array, the solution should report any peak element.

Input: [8, 9, 10, 2, 5, 6]
Output: 10 or 6

Input: [8, 9, 2, 5, 6, 3]
Output: 9 or 6

• If the peak element is not located, the procedure should return -1.

Input: []
Output: -1

 */

class Solution
{
	public static int findPeakElement(int[] arr)
	{
		int l = 0, r = arr.length - 1;
		if (arr.length > 1) {
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if(mid == 0) {
					if(arr[0] > arr[1]) {
						return arr[0];
					}
					else {
						return arr[1];
					}
				}
				else if(mid == arr.length - 1) {
					if(arr[mid - 1] > arr[mid]) {
						return arr[mid - 1];
					}
					else {
						return arr[mid];
					}
				}
				else {
					if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
						return arr[mid];
					}
					else if(arr[mid - 1] > arr[mid]) {
						r = mid - 1;
					}
					else {
						l = mid + 1;
					}
				}
			} 
		}
		else if (arr.length == 1){
			return arr[0];
		}
		return -1;
	}
}


// Editorial
class Main
{
    // Recursive function to find the peak element in an array
    public static int findPeakElement(int[] nums, int left, int right)
    {
        // find the middle element. To avoid overflow, use mid = low + (high - low) / 2
        int mid = (left + right) / 2;
 
        // check if the middle element is greater than its neighbors
        if ((mid == 0 || nums[mid - 1] <= nums[mid]) &&
                (mid == nums.length - 1 || nums[mid + 1] <= nums[mid])) {
            return mid;
        }
 
        // If the left neighbor of `mid` is greater than the middle element,
        // find the peak recursively in the left subarray
        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            return findPeakElement(nums, left, mid - 1);
        }
 
        // If the right neighbor of `mid` is greater than the middle element,
        // find the peak recursively in the right subarray
        return findPeakElement(nums, mid + 1, right);
    }
 
    public static int findPeakElement(int[] nums)
    {
        // base case
        if (nums == null || nums.length == 0) {
            System.exit(-1);
        }
 
        int index = findPeakElement(nums, 0, nums.length - 1);
        return nums[index];
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 8, 9, 10, 2, 5, 6 };
        System.out.println("The peak element is " + findPeakElement(nums));
    }
}
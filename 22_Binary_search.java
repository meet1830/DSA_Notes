// binary search algorithm
// recursive and iterative approach
public class P1_Binary_search {
    public static int bSearchRec (int[] arr, int target, int l, int r) {
        if (l>r) return -1;
        int mid = (l+r)/2;
        if (arr[mid] == target) {
            return mid;
        }
        else if (target < arr[mid]) {
            return bSearchRec (arr, target, l, mid - 1);
        }
        else {
            return bSearchRec (arr, target, mid + 1, r);
        }
    }
    public static int bSearchIter (int[] arr, int target, int l, int r) {
        while (l <= r) {
            int mid = (l+r)/2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (target < arr[mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 5;
        int l, r;
        // int resultIndex = bSearchIter(arr, target, 0, arr.length - 1);
        int resultIndex = bSearchRec(arr, target, 0, arr.length - 1);
        System.out.println(resultIndex);
    }
}

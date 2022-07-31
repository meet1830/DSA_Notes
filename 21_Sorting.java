// 0. linear search
// tc -> O(n), O(n), O(1)
// worst, average, best case
// sc -> O(1)


/*
Sorting algorithms 
1. Bubble sort
2. Selection sort
3. Insertion sort
4. Merge sort
5. Quick sort
*/


public class P1_Sorting {

    // 1. Bubble sort 
    // tc -> O(n^2), O(n^2), O(n)
    // sc -> O(1)
    // placing elements with the highest value at last with each iteration. after first iteration the largest element will be placed at last. hence in next iteration can ignore this element in comparison. similarly in next iteration ignore last two elements. 
    // if condition of comparison reversed, j > n - i - 1, then array sorted in descending order
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    // 2. Selection sort
    // tc -> O(n^2), O(n^2), O(n^2)
    // sc -> O(1)
    // everytime we find out the minimum element and then swap it with the outer element
    // swapping only one time per loop. In the first iteration, the smallest element will be placed at the start. Hence dont consider it next time to find out smallest element
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }


    // 3. Insertion sort
    // tc -> O(n^2), O(n^2), O(n)
    // sc -> O(1)
    // divide the array into two parts at first the partition will be after the first element.
    // compare all the elements of the left partition with the first element of right partition
    // start from right most element from the left partition and go till 0. 
    // if right is smaller then bring the left bigger element at right's place. 
    // its own place will remain empty or say value will be equal. 
    // now if again the leftwards element is smaller then move it index + 1 or at the prev element's place. 
    // this is creating space for the right element with whom we are comparing. 
    // keep making space and at last place the stored value at that place.
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                //Keep swapping
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }



    // both merge sort and quick sort is based on divide and conquer
    // in recursion calls for mergesort and quicksort named functions, the array is recursively divided into parts

    // 4. Merge sort
    // in merge sort the mergesort function is called recursively each time and hence the array is constantly partitoned till it has a single element left in it
    // then the merge function is called which then merges both the left and the right side and ensures that the array made using both the left and right partitons considered is sorted and finally the whole array is sorted after the last recursion call
    // tc -> O(nlogn), O(nlogn), O(nlogn)
    // sc -> O(n)
    public static void mergeSort (int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int mid = l + (r - l) / 2;
        mergeSort (arr, l, mid);
        mergeSort (arr, mid + 1, r);
        merge (arr, l, mid, r);
    }
    
    public static void merge (int[] arr, int l, int mid, int r) {
        // determine sizes and define temp array
        int sl = l;
        int sr = mid + 1;
        int[] merged = new int[r - l + 1];
        
        // copy elements in temp array in sorted fashion
        int x = 0;
        while (sl <= mid && sr <= r) {
            if (arr[sl] <= arr[sr]) {
                merged[x++] = arr[sl++];
            } else {
                merged[x++] = arr[sr++];
            }
        }
        
        // copy remaining elements to the array
        while (sl <= mid) {
            merged[x++] = arr[sl++];
        }
        while (sr <= r) {
            merged[x++] = arr[sr++];
        }
        
        // copy elements from sorted merged array to original array
        for (int i = 0, j = l; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }


    // 5. Quick sort
    // in quick sort, the array elements before pivot elements should be less than the pivot element and of the right side should be bigger than pivot element
    // hence part function does swapping to achieve this
    // quicksort function is recursively called and hence the array is partitioned till the partition has only 1 element in it and before calling the next recursion call, it is ensured that the above property is attained. and hence at last the whole array is sorted
    // tc -> O(n^2), O(nlogn), O(nlogn)
    // sc -> O(logn)
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = part(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    public static int part(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // to get the pivot element to correct index
        swap(arr, i + 1, r);
        return i + 1;
    }



    // helper functions
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println(" ");
    }



    public static void main(String args[]) {
        int[] arr = { 5, 10, 4, 2, 1, 8 };

        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // mergeSort(arr, 0, arr.length - 1);
        // quickSort(arr, 0, arr.length - 1);

        printArray(arr);
    }
}

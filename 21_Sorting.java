/*
Sorting algorithms 
1. Bubble sort
2. Insertion sort
3. Selection sort
4. Merge sort
5. Quick sort
*/

public class P1_Sorting {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // printArray(arr);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > x) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = x;
            // printArray(arr);
        }
    }

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
            // printArray(arr);
        }
    }

    public static void merge(int[] arr, int l, int r, int m) {
        // determine sizes and define temp array
        int sl = m - l + 1;
        int sr = r - m;
        int[] left = new int[sl];
        int[] right = new int[sr];

        // copy elements in temp array in sorted fashion
        for (int i = 0; i < sl; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < sr; i++) {
            right[i] = arr[m + 1 + i];
        }

        // compare elements and place in original array
        int i = 0, j = 0, k = l;
        while (i < sl && j < sr) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        // copy remaining elements to the array
        while (i < sl) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < sr) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, r, m);
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

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = part(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

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
        // insertionSort(arr);
        // selectionSort(arr);
        // mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}

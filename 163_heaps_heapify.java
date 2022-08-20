// heaps -> max heap and min heap

public class heaps_heapify {
  
    // converting normal bt to max heap
    public static void heapify(int[] arr, int n, int i) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
  
      int max = i;
  
      // finding max element from child to swap with root 
      // after && condition so that iterator remains in bound
      if(left < n && arr[left] > arr[max]) max = left;
      if(right < n && arr[right] > arr[max]) max = right;
  
      // check if max is not equal to root
      if(i != max) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
  
        // calling func again for heapifying subtree after swapping
        heapify(arr, n, max);
      }
  
      // to convert to min heap find min instead of max
  
      // tc -> O(logn)
    }
  
  
    /*
      Steps to perform heapsort
      convert the array to max heap
      swap root node value(which is max element right now) with last index of array
      repeat above without considering last element
    */
    public static void heapSort(int[] arr) {
      int n = arr.length;
  
      // converting to max heap
      for(int i = n / 2 - 1; i >= 0; i--) 
        heapify(arr, n, i);
  
      // swapping first element with last index 
      // not considering last element after iteration and calling heapify to sort
      for(int i = n - 1; i >= 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
  
        heapify(arr, i, 0); // here length of heapify as i
      }
  
      // to reverse sort change heapify to convert to min heap
  
      // tc -> for converting to max heap O(nlogn), for swap and heapify -> O(nlogn) hence total O(nlogn)
    }
  
  
    public static void main(String[] args) {
      int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
      int n = arr.length;
  
      // heap is always taken as an array
      // children's index always starts from n/2th index
      // for converting into a map or min heap func has to be ran for every parent node
      // or else one part(right or left) of the parent may not get converted and subsequently its sub trees 
      for(int i = n / 2 - 1; i >= 0; i--) 
        heapify(arr, n, i);
      
      heapSort(arr);
      for(int x : arr) 
        System.out.print(x + " ");
  
      System.out.println();
    }
  }
  
  
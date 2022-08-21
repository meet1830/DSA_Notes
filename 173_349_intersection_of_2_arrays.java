/* 
 * 349. Intersection of Two Arrays 
Question:
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 
Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
*/



/*
brute method - run 2 for loops if the element from the first array matches any element in the second array then add it to the set which is predefined. (set because output array should not contain duplicate elements)
*/


/*
if arrays are sorted
tc -> o(m + n) sc -> o(m + n)
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } 
            else if(nums1[i] > nums2[j]) 
                j++;
            else 
                i++;
        }
        
        int[] res = new int[set.size()];
        int k = 0;
        for(int x : set) {
            res[k++] = x;
        }
        
        return res;
    }
}


/*
if any one array is sorted
can also find element of nums2 if it exists in nums1 using binary search. tc -> nlogn + n + logn sc -> n 
*/
class Solution {
    public boolean bSearch(int target, int[] arr) { //logn
        int l = 0, r = arr.length - 1;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            
            if(arr[mid] == target) 
                return true;
            else if(arr[mid] > target) 
                r = mid - 1;
            else 
                l = mid + 1;
        }
        
        return false;
    }
    public int[] intersection(int[] nums1, int nums2[]) {
        Arrays.sort(nums1); //nlogn
        
        HashSet<Integer> intersect = new HashSet<>();
        for(int x : nums2) //n
            if(bSearch(x, nums1))
                intersect.add(x);
        
        int[] res = new int[intersect.size()];
        int i = 0;
        for(int x : intersect) //n
            res[i++] = x;
        
        return res;
    }
}


/*
another solution -> define hashset and add all elements from first array to it. then define and new arraylist and iterate through array 2 if set contains that element then add it to list. finally convert list to array and return. remove elements from set in second loop or else will get added to list multiple times whenever encountered.
can also use set instead of arraylist. 
tc -> m + n sc -> m + n
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x: nums1) 
            set.add(x);
        
        List<Integer> list = new ArrayList<Integer>();
        for(int x : nums2) 
            if(set.contains(x)) {
                list.add(x);
                set.remove(x);   
            }
        
        int[] res = new int[list.size()];
        int i = 0;
        for(int x : list)
            res[i++] = x;
        
        return res;
    }
}


/*
another method -> use two sets containing elements from both the arrays added to them using loop. then use set1.retainAll(set2)
then define an array and add set 1 elements to array and return
tc -> m + n on avg and m * n for worst case due to retainall method sc -> m + n for sets
*/


// using hashmaps
// tc -> m + n + 2 * map size sc -> res size
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int x : nums1) 
            map.put(x, false);
        
        int countTrue = 0;
        
        for(int x : nums2) 
            if(map.containsKey(x))
                map.put(x, true);
        
        // counting elements for array size
        Iterator mapCnt = map.entrySet().iterator();
        while(mapCnt.hasNext()) {
            Map.Entry mapElement = (Map.Entry)mapCnt.next();
            if(!(boolean)mapElement.getValue())
                countTrue++;
        }
    
        int[] res = new int[countTrue];
        int i = 0;
        
        // putting elements inside array
        Iterator mapIt = map.entrySet().iterator();
        while(mapIt.hasNext()) {
            Map.Entry mapElement = (Map.Entry)mapIt.next();
            if((boolean)mapElement.getValue())
                res[i++] = (int)mapElement.getKey();
        }
        
        return res;
    }
}



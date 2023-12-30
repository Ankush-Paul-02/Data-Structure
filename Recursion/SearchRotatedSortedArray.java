package Recursion;
public class SearchRotatedSortedArray {

    /*
        input: sorted, rotated array with distict numbers(in ascending order)
        It is rotated at a pivot point. Find the index of given element.
        [4, 5, 6, 7, 0, 1, 2]   target = 0  output = 4
    */

    // We can call it a modified binary search
    // Devide & Conquer

    public static int search(int arr[], int target, int si, int ei) {
        if(si > ei) {
            return -1;
        }
        int mid = si + (ei-si)/2;
        //case found
        if(arr[mid] == target) {
            return mid;
        }

        // mid on line 1
        if(arr[si] <= arr[mid]) {
            // case a: left
            if(arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid-1);
            } else {
                // case a: right
                return search(arr, target, mid+1, ei);
            }
        } else {    // mid on line 2
            // case c: right
            if(arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid+1, ei);
            } else {
                // case d: left
                return search(arr, target, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int index = search(arr, 0, 0, arr.length-1);
        System.out.println(index);
    }
}

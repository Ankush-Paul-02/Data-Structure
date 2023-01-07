public class Heap_Sort {

    // Max Heap
    public static void heapify(int arr[], int index, int size) {
        int left = 2*index + 1;
        int right = 2*index + 2;

        int maxIndex = index;

        if(left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }

        if(right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }

        if(maxIndex != index) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            heapify(arr, maxIndex, size);
        }
    }

    public static void heapSort(int arr[]) {    // O(nlogn)
        // step 1: Build max heap
        int n = arr.length;
        for(int i = n/2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step 2: Push largest at bottom
        for(int i = n-1; i >= 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5 ,3};
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

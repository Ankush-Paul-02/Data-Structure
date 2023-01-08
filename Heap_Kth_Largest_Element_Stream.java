import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Heap_Kth_Largest_Element_Stream {

    static PriorityQueue<Integer> min;
    static int k;

    static List<Integer> getAllKthNumber(int arr[]) {
        List<Integer> list = new ArrayList<>();
        for(int val : arr) {
            if(min.size() < k) {
                min.add(val);
            } else {
                if(val > min.peek()) {
                    min.poll();
                    min.add(val);
                }
            }
        }
        if(min.size() >= k) {
            list.add(min.peek());
        } else {
            list.add(-1);
        }
        return list;
    }

    public static void main(String[] args) {
        /*
         *  We have an infinite stream, find the kth largest element
         *  at any point of time.
         */

        min = new PriorityQueue<>();
        k = 4;
        int arr[] = {1, 2, 3, 4, 5, 6};
        List<Integer> list = getAllKthNumber(arr);

        for (int x : list) {
            System.out.print(x + " ");
        }
    }
}

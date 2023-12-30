package Heap;
import java.util.PriorityQueue;

public class Heap_Priority_Queue_Sliding_Window_Maximum {   // Maximum of all sub arrays of size k
    
    static class Pair implements Comparable<Pair> {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair pair) {
            return pair.value - this.value; // descending order
        }
    }
    
    public static void main(String[] args) {    // O(nlogk)
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // window size
        int res[] = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for(int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().value;
        for(int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().index <= (i-k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().value;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}

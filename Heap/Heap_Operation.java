package Heap;
import java.util.ArrayList;

public class Heap_Operation {

    // MIN HEAP
    static class Heap {
        ArrayList<Integer> list = new ArrayList<>();   
        
        public void add(int data) { // O(logn)
            list.add(data);

            int childIndex = list.size()-1;
            int parentIndex = (childIndex-1)/2;

            while(list.get(childIndex) < list.get(parentIndex)) {   // O(logn)
                // swap
                int temp = list.get(childIndex);
                list.set(childIndex, list.get(parentIndex));
                list.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }
        }

        public int peek() {
            return list.get(0);
        }

        private void heapify(int index) { // O(logn)
            int left = 2*index + 1;
            int right = 2*index + 2;
            int minIndex = index;
            
            if(left < list.size() && list.get(minIndex) > list.get(left)) {
                minIndex = left;
            }
            if(right < list.size() && list.get(minIndex) > list.get(right)) {
                minIndex = right;
            }

            if(minIndex != index) {
                // swap
                int temp = list.get(index);
                list.set(index, list.get(minIndex));
                list.set(minIndex, temp);

                heapify(minIndex);
            }
        }

        public int remove() { // O(logn)
            int data = list.get(0);

            // step 1 : swap first & last
            int temp = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1, temp);

            // step 2: delete last
            list.remove(list.size()-1);

            // step 3: Heapify for fixing the data
            heapify(0);
            return data;

        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);

        while(!heap.isEmpty()) {    // heap sort-->O(nlogn)
            System.out.println(heap.peek());
            heap.remove();
        }
    }
}

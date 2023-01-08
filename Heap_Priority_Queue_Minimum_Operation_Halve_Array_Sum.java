import java.util.*;

public class Heap_Priority_Queue_Minimum_Operation_Halve_Array_Sum {

    static int minOps(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            priorityQueue.add(-list.get(i));
        }

        double temp = sum;
        int count = 0;
        while(temp > sum/2) {
            int x = -priorityQueue.peek();
            priorityQueue.remove();
            temp -= Math.ceil(x*1.0/2);
            priorityQueue.add(x/2);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        /*
         * We have an array Arr[],the task is to find out the minimum
         * number of operations to make the sum of array elements lesser 
         * or equal to half of its initial value.In one such operation,it 
         * is allowed to half the value of any array element.
         */

        ArrayList<Integer> num = new ArrayList<>(
            List.of(4, 6, 3, 9, 10, 2)
        );
        int count = minOps(num);
        System.out.println(count);
    }   
}

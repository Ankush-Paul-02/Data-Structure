package Queue;
import java.util.PriorityQueue;

public class Queue_Connect_N_Ropes {

    /* Given are N ropes of different lengths,the task is to connect these
      ropes into one rope with minimum cost, such that the cost to connect
      two ropes is equal to the sum of their lengths */

    static int minCost(int arr[], int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
        }

        int res = 0;
        while (priorityQueue.size() > 1) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            res += first+second;
            priorityQueue.add(first+second);
        }
        return res;
    }
    public static void main(String[] args) {
        int len[] = {4, 3, 2, 6};
        int size = len.length;
        System.out.println("Total cost for connecting ropes is " + minCost(len, size));
    }
}

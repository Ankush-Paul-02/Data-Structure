package Heap;
import java.util.PriorityQueue;

public class Heap_Priority_Queue_Connect_N_Ropes {
    public static void main(String[] args) {
        /*
         *  Given are N ropes of different lengths, the task is to connect these ropes into
         *  one rope with minimum cost, such that the cost to connect two ropes
         *  is equal to the sum of their lengths.
         */

        int ropes[] = {2, 3, 3, 4 ,6}; 

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            priorityQueue.add(ropes[i]);
        }

        int cost = 0;
        while(priorityQueue.size() > 1) {
            int min1 = priorityQueue.remove();
            int min2 = priorityQueue.remove();
            cost += min1+min2;
            priorityQueue.add(min1+min2);
        }

        System.out.println(cost);
    }
}

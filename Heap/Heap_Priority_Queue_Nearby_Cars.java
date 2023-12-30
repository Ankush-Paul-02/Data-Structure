package Heap;
import java.util.PriorityQueue;

public class Heap_Priority_Queue_Nearby_Cars {

    static class Position implements Comparable<Position> {
        int x, y, distanceSqr, index;
        Position(int x, int y, int distanceSqr, int index) {
            this.x = x;
            this.y = y;
            this.distanceSqr = distanceSqr;
            this.index = index;
        }

        @Override
        public int compareTo(Position position) {
            return this.distanceSqr - position.distanceSqr;
        }
    }

    public static void main(String[] args) {
        /*
         *  We are given N points in a 2D plane which are locations of
         *  N cars. If we are at the origin, print the nearest K cars.
         */

        int position[][] = {
            {3, 3},
            {5, -1},
            {-2, 4}
        };
        int k = 2;

        PriorityQueue<Position> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < position.length; i++) {
            int distanceSqr = position[i][0]*position[i][0] + position[i][1]*position[i][1];
            priorityQueue.add(new Position(position[i][0], position[i][1], distanceSqr, i));
        }

        // nearest K car
        for (int i = 0; i < k; i++) {
            System.out.println("Car " + priorityQueue.remove().index);
        }

    }
}



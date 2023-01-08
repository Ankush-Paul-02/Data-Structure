import java.util.PriorityQueue;

public class Heap_Priority_Queue_Weakest_Soldier {

    static class Weak implements Comparable<Weak> {
        int soldiers, index;
        Weak(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Weak weak) {
            if(this.soldiers == weak.soldiers) {
                return this.index - weak.index;
            }
            return this.soldiers - weak.soldiers;
        }
    }


    public static void main(String[] args) {
        /*
         *  We are given an mxn binary matrix of 1's(soldiers) and 0's(civilians).
         *  The soldiers are positioned i front of the civilians. That is, all the
         *  1's appear to the left of all the 0's in each row.
         *  A row i is weaker than a row j if one of the following is true:
         *      The number of soldiers in row i is less than he number of soldiers
         *      in row j.
         *      Both rows have the same number of soldiers in row i is less than the
         *      number of soldiers in row j.
         *  Find the k weakest row.
         */

        int arr[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        int k = 2;

        PriorityQueue<Weak> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            int soldiers = 0;
            for(int j = 0; j < arr[0].length; j++) {
                soldiers += arr[i][j] == 1 ? 1 : 0;
            }
            priorityQueue.add(new Weak(soldiers, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("Row " + priorityQueue.remove().index);
        }
    }
}

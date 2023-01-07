import java.util.*;

class Priority_Queue {

    static class Student implements Comparable<Student> {   // Comparable is a interface => classes can compare it's objects
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student student) {
            return this.rank - student.rank;
        }
    }

    public static void main(String[] args) {

        // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());  
        // /*
        //  * Comparator for descending order otherwise priority queue always print data in ascending order 
        //  * Comparator is a Interface which defines the logic of comparison
        //  */
        // priorityQueue.add(3);   // O(log n)
        // priorityQueue.add(7);
        // priorityQueue.add(1);
        // priorityQueue.add(9);

        // System.out.println(priorityQueue);  // 1 3 7 9

        // while (!priorityQueue.isEmpty()) {
        //     System.out.println(priorityQueue.peek());   // O(n)
        //     priorityQueue.remove();
        // }

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Student("Ankush Paul", 2));
        priorityQueue.add(new Student("Purbanka Ghosh", 1));
        priorityQueue.add(new Student("Patralekha Patra", 3));

        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peek().name + "-->" + priorityQueue.peek().rank);
            priorityQueue.remove();
        }
    }
}
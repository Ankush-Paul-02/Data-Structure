package Graph;
import java.util.ArrayList;
import java.util.Vector;

public class Graph_Whether_Possible_Finish_Task {

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<ArrayList<Integer>> make_graph(int numTasks, Vector<Pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numTasks);
        
        for (int i = 0; i < numTasks; i++) {
            graph.add(new ArrayList<>());
        }

        for (Pair pair : prerequisites) {
            graph.get(pair.second).add(pair.first);
        }

        return graph;
    }

    static int[] compute_inDegree(ArrayList<ArrayList<Integer>> graph) {
        int degrees[] = new int[graph.size()];

        for (ArrayList<Integer> neighbors : graph) {
            for (int neigh : neighbors) {
                degrees[neigh]++;
            }
        }
        return degrees;
    }

    static boolean canFinish(int numTasks, Vector<Pair> prerequisites) {    //! O(n)
        ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);
        int degrees[] = compute_inDegree(graph);

        for (int i = 0; i < numTasks; i++) {
            int j = 0;
            for(; j < numTasks; j++) {
                if(degrees[j] == 0) {
                    break;
                }
            }
            if(j == numTasks) {
                return false;
            }
            degrees[j] = -1;
            for (int neigh : graph.get(j)) {
                degrees[neigh]--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
         *  There are a total of n tasks ypu have to pick, labelled from 
         *  0 to n-1. Some tasks may have prerequisites, for examples to 
         *  pick task 0 you have to first pick task 1, which is expressed
         *  as a pair: [0, 1] Given the total number of tasks and a list
         *  of prerequisites pairs, is it possible for you to finish all
         *  tasks.
         */

        int numTasks = 4;
        Vector<Pair> prerequisites = new Vector<Pair>();

        prerequisites.add(new Pair(1, 0));
        prerequisites.add(new Pair(2, 1));
        prerequisites.add(new Pair(3, 2));

        if(canFinish(numTasks, prerequisites)){
            System.out.println("Possible to finish all the tasks.");
        } else {
            System.out.println("Impossible to finish all the tasks.");
        }
    }
}

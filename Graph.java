import java.util.*;

public class Graph {

    static class Edge {
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        /*
         *          (5)     (3)
         *      0 ----- 1 ----- 3
         *              |       |
         *             | (1)    | (1)
         *        (2)  |        |  
         *     4 ----- 2 -------   
         */

        int vertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertex];    // null -> empty arrayList

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5));
        // 1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[2].add(new Edge(2, 3, 1));
        // 3 - vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        // 4 - vertex
        graph[4].add(new Edge(4, 2, 2));


        // 2's neighbors
        for (int i = 0; i < graph[2].size(); i++) {
            System.out.println(graph[2].get(i).destination);
        }
    }
}

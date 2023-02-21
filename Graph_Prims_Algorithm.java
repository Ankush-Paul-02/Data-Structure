import java.util.*;

public class Graph_Prims_Algorithm {

    static class Edge {
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 30));
        graph[0].add(new Edge(0, 2, 15));

        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 30));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        graph[3].add(new Edge(3, 0, 30));
    }

    static class Pair implements Comparable<Pair>{
        int vertex, cost;
        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(0, 0));

        int finalCost = 0;  // MST cost/ total minimum weight

        while(!priorityQueue.isEmpty()) {
            Pair curPair = priorityQueue.remove();
            if(!visited[curPair.vertex]) {
                visited[curPair.vertex] = true;
                finalCost += curPair.cost;

                for (int i = 0; i < graph[curPair.vertex].size(); i++) {
                    Edge edge = graph[curPair.vertex].get(i);
                    priorityQueue.add(new Pair(edge.destination, edge.weight));
                }
            }
        }
        System.out.println("Final min cost of MST = " + finalCost);
    }

    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        prims(graph);
    }
}

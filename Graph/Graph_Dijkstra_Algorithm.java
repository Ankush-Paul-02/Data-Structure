package Graph;
import java.util.*;

public class Graph_Dijkstra_Algorithm {

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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int node, path;
        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // Path based sorting
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int source) {  // O(v + logV)
        int distance[] = new int[graph.length]; // Distance[i] = source to i
        for (int i = 0; i < distance.length; i++) {
            if(i != source) {
                distance[i] = Integer.MAX_VALUE;    // +infinity
            }
        }

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(source, 0));

        while(!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();
            if(!visited[curr.node]) {
                visited[curr.node] = true;
                // neighbours
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge edge = graph[curr.node].get(i);
                    int u = edge.source;
                    int v = edge.destination;
                    int wt = edge.weight;

                    if(distance[u] + wt < distance[v]) {    // update distance of src to v
                        distance[v] = distance[u] + wt;
                        priorityQueue.add(new Pair(v, distance[v]));
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
}

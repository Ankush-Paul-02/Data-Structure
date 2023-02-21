import java.util.*;

class Graph_Bellman_Ford_Algorithm {

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

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    static void createGraph2(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int source) { // O(V*E)
        int distance[] = new int[graph.length];
        for (int i = 0; i < distance.length; i++) {
            if (i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // Algorithm
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) { // O(V)
            // edges - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge edge = graph[j].get(k);
                    // u, v, wt
                    int u = edge.source;
                    int v = edge.destination;
                    int wt = edge.weight;
                    if (distance[u] + wt < distance[v] && distance[u] != Integer.MAX_VALUE) {
                        distance[v] = distance[u] + wt; // Relaxation
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int source, int vertex) { // O(V*E)
        int distance[] = new int[vertex];
        for (int i = 0; i < distance.length; i++) {
            if (i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // Algorithm
        for (int i = 0; i < vertex - 1; i++) { // O(V)
            // edges - O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge edge = graph.get(j);
                // u, v, wt
                int u = edge.source;
                int v = edge.destination;
                int wt = edge.weight;
                if (distance[u] + wt < distance[v] && distance[u] != Integer.MAX_VALUE) {
                    distance[v] = distance[u] + wt; // Relaxation
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph, 0);

        ArrayList<Edge> edges = new ArrayList<>();
        createGraph2(edges);
        bellmanFord2(edges, 0, V);
    }
}
import java.util.*;

public class Graph_Bridge_Tarjans_Algorithm {

    static class Edge {
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int current, int parent, int discoveryTime[], int lowestDiscoveryTime[], boolean visited[], int time) {
        visited[current] = true;
        discoveryTime[current] = lowestDiscoveryTime[current] = ++time;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);  // edge.source -- edge.destination
            int neighbor = edge.destination;
            if(neighbor == parent) {
                continue;
            } else if(!visited[neighbor]) {
                dfs(graph, neighbor, current, discoveryTime, lowestDiscoveryTime, visited, time);
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], lowestDiscoveryTime[neighbor]);
                if(discoveryTime[current] < lowestDiscoveryTime[neighbor]) {
                    System.out.println("Bridge : " + current + " --- " + neighbor);
                }
            } else {
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], discoveryTime[neighbor]);
            }
        }
    }

    public static void tarjans_bridge(ArrayList<Edge> graph[], int vertices) {  //! O(v+e)
        int discoveryTime[] = new int[vertices];
        int lowestDiscoveryTime[] = new int[vertices];
        int time = 0;
        boolean visited[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                dfs(graph, i, -1, discoveryTime, lowestDiscoveryTime, visited, time);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        tarjans_bridge(graph, vertices);
    }
}

import java.util.*;

public class Graph_Articulation_Point_Tarjans_Algorithm {

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

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge> graph[], int current, int parent, int discoveryTime[], int lowestDiscoveryTime[], int time, boolean visited[], boolean articulationPoint[]) { //! O(v+e)
        visited[current] = true;
        discoveryTime[current] = lowestDiscoveryTime[current] = ++time;
        int children = 0;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            int neighbor = edge.destination;

            if(parent == neighbor) {
                continue;
            } else if(visited[neighbor]) {
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], discoveryTime[neighbor]);
            } else {
                dfs(graph, neighbor, current, discoveryTime, lowestDiscoveryTime, time, visited, articulationPoint);
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], lowestDiscoveryTime[neighbor]);

                if(parent != -1 && discoveryTime[current] <= lowestDiscoveryTime[neighbor]) {
                    articulationPoint[current] = true;
                }
                children++;
            }
        }

        if(parent == -1 && children> 1) {
            articulationPoint[current] = true;
        }
    }

    public static void getArticulationPoint(ArrayList<Edge> graph[], int vertices) {
        int discoveryTime[] = new int[vertices];
        int lowestDiscoveryTime[] = new int[vertices];
        int time = 0;
        boolean visited[] = new boolean[vertices];
        boolean articulationPoint[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                dfs(graph, i, -1, discoveryTime, lowestDiscoveryTime, time, visited, articulationPoint);
            }
        }

        for (int i = 0; i < vertices; i++) {
            if(articulationPoint[i]) {
                System.out.println("Articulation point: " + i);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);

        getArticulationPoint(graph, vertices);
    }
}

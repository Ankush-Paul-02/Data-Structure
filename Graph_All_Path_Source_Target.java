import java.util.*;

public class Graph_All_Path_Source_Target {

    static class Edge {
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {  // O(v^v)
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void printAllPath(ArrayList<Edge> graph[], int source, int destination, String path) {
        if(source == destination) {
            System.out.println(path+destination);
            return;
        }
        for(int i = 0; i < graph[source].size(); i++) {
            Edge edge = graph[source].get(i);
            printAllPath(graph, edge.destination, destination, path+source);
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        int source = 5, destination = 1;
        printAllPath(graph, source, destination, "");
    }
}

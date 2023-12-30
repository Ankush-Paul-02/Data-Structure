package Graph;
import java.util.ArrayList;

public class Graph_Directed_Cyclic {

    static class Edge {
        int source, destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if(isCycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int current, boolean visited[], boolean stack[]) {
        visited[current] = true;
        stack[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(stack[edge.destination]) {   // cycle exists
                return true;
            }
            if(!visited[edge.destination] && isCycleUtil(graph, edge.destination, visited, stack)) {
                return true;
            }
        }
        stack[current] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}

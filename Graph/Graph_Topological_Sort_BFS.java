package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Graph_Topological_Sort_BFS {   // Kahn's Algorithm

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
        
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calculate_inDegree(ArrayList<Edge> graph[], int inDegree[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge edge = graph[i].get(j);
                inDegree[edge.destination]++;
            }
        }
    }

    public static void topological_sort(ArrayList<Edge> graph[]) {
        int inDegree[] = new int[graph.length];
        calculate_inDegree(graph, inDegree);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // bfs
        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.print(current + " ");

            for (int i = 0; i < graph[current].size(); i++) {
                Edge edge = graph[current].get(i);
                inDegree[edge.destination]--;
                if (inDegree[edge.destination] == 0) {
                    queue.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        topological_sort(graph); 
    }
}

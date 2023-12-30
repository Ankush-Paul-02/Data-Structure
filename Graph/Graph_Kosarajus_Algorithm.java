package Graph;
import java.util.*;

public class Graph_Kosarajus_Algorithm {

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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topological_sort(ArrayList<Edge> graph[], int current, boolean visited[], Stack<Integer> stack) {
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(!visited[edge.destination]) {
                topological_sort(graph, edge.destination, visited, stack);
            }
        }
        stack.push(current);
    }

    public static void dfs(ArrayList<Edge> graph[], int current, boolean visited[]) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(!visited[edge.destination]) {
                dfs(graph, edge.destination, visited);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int vertices) {    //! O(v+e)
        //? step 1 : Topological Sort
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                topological_sort(graph, i, visited, stack);
            }
        }

        //? step 2 : Transpose Graph
        ArrayList<Edge> transpose[] = new ArrayList[vertices];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false; //? Reinitialize
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < graph[i].size(); j++) { // neighbor for every vertex
                Edge edge = graph[i].get(j);    //! edge.source --> edge.destination
                transpose[edge.destination].add(new Edge(edge.destination, edge.source));   //! edge.destination --> edge.source
            }
        }

        //? step 3 : DFS according to stack nodes on the transpose graph
        while(!stack.isEmpty()) {
            int current = stack.pop();
            if(!visited[current]) {
                System.out.print("Strongly Connected Components : ");
                dfs(transpose, current, visited);   //! Strongly connected components
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        kosaraju(graph, vertices);
    }
}

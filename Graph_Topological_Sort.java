import java.util.*;

public class Graph_Topological_Sort {

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

    public static void topological_sort(ArrayList<Edge> graph[]) {  // O(V+E)
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                topological_sort_util(graph, i, visited, stack);   // modified dfs
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topological_sort_util(ArrayList<Edge> graph[], int current, boolean visited[], Stack<Integer> stack) {
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!visited[e.destination]) {
                topological_sort_util(graph, e.destination, visited, stack);
            }
        }
        stack.push(current);
    }

    public static void main(String[] args) {
        /*
         *  Directed Acyclic Graph(DAG) is a directed graph with no cycles.
         *  Topological sorting is used only for DAGs. It is a linear order
         *  of vertices such that every directed edge u->v, the vertex u comes
         *  before v in the order.
         */

        int vertices = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        topological_sort(graph); 
    }
}
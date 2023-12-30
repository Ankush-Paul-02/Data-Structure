package Graph;
import java.util.*;

public class Graph_Mother_Vertex {

    static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> list) {
        list.get(u).add(v);
    }

    static void dfsUtil(ArrayList<ArrayList<Integer>> list, int v, boolean visited[]) {
        visited[v] = true;

        for(int x : list.get(v)) {
            if(!visited[x]) {
                dfsUtil(list, x, visited);
            }
        }
    }

    static int motherVertex(ArrayList<ArrayList<Integer>> list, int V) {    //! O(v+e)
        boolean visited[] = new boolean[V];
        int v = -1;

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfsUtil(list, i, visited);
                v = i;
            }
        }
        boolean check[] = new boolean[V];
        dfsUtil(list, v, check);
        for (boolean val : check) {
            if(!val) {
                return -1;
            }
        }
        return v;
    }

    public static void main(String[] args) {
        /*
         *  We have a Directed Graph, find a Mother Vertex in the Graph.
         *  A Mother Vertex is a vertex through which we can reach all the
         *  other vertices of the graph.
         */

        int V = 7, E = 8;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        addEdge(0, 1, list);
        addEdge(0, 2, list);
        addEdge(1, 3, list);
        addEdge(4, 1, list);
        addEdge(6, 4, list);
        addEdge(5, 6, list);
        addEdge(5, 2, list);
        addEdge(6, 0, list);

        System.out.println("The mother vertex is : " + motherVertex(list, V));
    }
}

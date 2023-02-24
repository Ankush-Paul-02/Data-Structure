import java.util.*;

public class Graph_Kruskal_Algorithm {

    static class Edge implements Comparable<Edge> {
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;   //? vertices
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void initialize() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) { //! O(4k) , where k is constant => O(1)
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); //? Path compression
    }

    public static void union(int a, int b) { //! O(1)
        int parentA = find(a);
        int parentB = find(b);

        if(rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if(rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int vertices) {   //! O(V + ElogE)   
        initialize();
        Collections.sort(edges);    //! O(ElogE)
        int mstCost = 0, count = 0;

        for (int i = 0; count < vertices-1; i++) {  //! O(V)
            Edge edge = edges.get(i);
            // (source, destination, weight)
            int parentA = edge.source;  // source = a
            int parentB = edge.destination; // destination = b

            if(parentA != parentB) {
                union(edge.source, edge.destination);
                mstCost += edge.weight;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, vertices);
    }
}

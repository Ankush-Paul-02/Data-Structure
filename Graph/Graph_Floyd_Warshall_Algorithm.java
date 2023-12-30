package Graph;
public class Graph_Floyd_Warshall_Algorithm {

    final static int INF = 99999, V = 4;

    void floydWarshall(int graph[][]) {
        int distance[][] = new int[V][V];
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                distance[i][j] = graph[i][j];
            }
        }
        for(int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        printSolution(distance);
    }

    void printSolution(int distance[][]) {
        System.out.println("The following matrix shows the shortest = " + "distance between every pair of vertices");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(distance[i][j] == INF) {
                    System.out.print("INF");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        Graph_Floyd_Warshall_Algorithm solution = new Graph_Floyd_Warshall_Algorithm();
        solution.floydWarshall(graph);
    }
}

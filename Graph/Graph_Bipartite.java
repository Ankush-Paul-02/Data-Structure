package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph_Bipartite {

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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // process 1
    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;  // no color
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(color[i] == -1) {    // BFS
                queue.add(i);
                color[i] = 0;   // yellow
                while (!queue.isEmpty()) {
                    int curr = queue.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(color[e.destination] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.destination] = nextColor;
                            queue.add(e.destination);
                        } else if(color[e.destination] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // process 2
    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean visited[ ] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                if(detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int current, int parent) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!visited[e.destination]) {
                if(detectCycleUtil(graph, visited, e.destination, current)) {
                    return true;
                }
            } else if(visited[e.destination] && e.destination != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(isBipartite(graph));

        if (!detectCycle(graph)) {
            System.out.println("Bipartite");
        } else {
            if(v % 2 == 0) {
                System.out.println("Bipartite");
            } else {
                System.out.println("Not Bipartite");
            }
        }
    }
}
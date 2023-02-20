import java.util.*;

class Graph_Detect_Cycle {

    static void addEdge(ArrayList<Integer> list[], int u, int v) {
        list[u].add(v);
        list[v].add(u);
    }

    static boolean isCycleConnected(ArrayList<Integer> list[], int s, int V, boolean visited[]) {
        
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0; i < list[u].size(); i++) {
                int v = list[u].get(i);
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    parent[v] = u;
                } else if(parent[u] != v) {
                    return true;
                }
            }
        }
        
        return false;
    }

    static boolean isCyclicDisconnected(ArrayList<Integer> list[], int v) {
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && isCycleConnected(list, i, v, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Integer> list[] = new ArrayList[V];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        addEdge(list, 0, 1);
        addEdge(list, 1, 2);
        addEdge(list, 2, 0);
        addEdge(list, 2, 3);

        if(isCyclicDisconnected(list, V)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
import java.util.*;

class Graph_Connecting_Cities_Minimum_Cost {

    static class Edge implements Comparable<Edge>{
        int destination, cost;
        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }

    public static int connectedCities(int cities[][]) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        boolean visited[] = new boolean[cities.length];

        priorityQueue.add(new Edge(0, 0));
        int finalCost = 0;

        while(!priorityQueue.isEmpty()) {
            Edge currEdge = priorityQueue.remove();
            if(!visited[currEdge.destination]) {
                visited[currEdge.destination] = true;
                finalCost += currEdge.cost;

                for (int i = 0; i < visited.length; i++) {
                    if(cities[currEdge.destination][i] != 0) {
                        priorityQueue.add(new Edge(i, cities[currEdge.destination][i]));
                    }     
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] = {
            {0, 1, 2, 3, 4},
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };
        System.out.println(connectedCities(cities));
    }
}
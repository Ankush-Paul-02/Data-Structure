import java.util.*;

class Graph_Cheapest_Flights_K_Stops {

    static class Edge {
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Information {
        int vertex, cost, stops;
        public Information(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int destination = flights[i][1];
            int weight = flights[i][2];

            Edge edge = new Edge(source, destination, weight);
            graph[source].add(edge);
        }
    }

    public static int cheapestFlight(int n, int flights[][], int source, int destination, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int distance[] = new int[n];
        for (int i = 0; i < distance.length; i++) {
            if(i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Information> queue = new LinkedList<>();
        queue.add(new Information(source, 0, 0));

        while(!queue.isEmpty()) {
            Information current = queue.remove();
            if(current.stops > k) {
                break;
            }
            for (int i = 0; i < graph[current.vertex].size(); i++) {
                Edge edge = graph[current.vertex].get(i);
                int v = edge.destination;
                int weight = edge.weight;

                if(current.cost + weight < distance[v] && current.stops <= k) {
                    distance[v] = current.cost + weight;
                    queue.add(new Information(v, distance[v], current.stops+1));
                }
            }
        }
        if(distance[destination] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return distance[destination];
        }
    }

    public static void main(String[] args) {
        /*
         *  There are n cities connected by some number of flights. You 
         *  are given an array flights where flights[i] = [from, to, price]
         *  indicates that there is a flight.
         *  You are also given three src, dst, and k, return the cheapest 
         *  price from sec to dst with at most k stops.
         *  If there is no such route, return -1;
         */

        int n = 4;
        int flights[][] = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int source = 0, destination = 3, k = 1;
        System.out.println(cheapestFlight(n, flights, source, destination, k));
    }
}
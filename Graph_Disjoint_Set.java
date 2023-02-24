public class Graph_Disjoint_Set {

    static int n = 7;
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
        return parent[x] = find(parent[x]);
    }

    //! Path compression optimization in union-find

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

    public static void main(String[] args) {
        initialize();
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}

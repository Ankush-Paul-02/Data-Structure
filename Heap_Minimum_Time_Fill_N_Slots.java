import java.util.LinkedList;
import java.util.Queue;

public class Heap_Minimum_Time_Fill_N_Slots {

    public static void minTime(int arr[], int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean vis[] = new boolean[n+1];
        int time = 0;

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
            vis[arr[i]] = true;
        }

        while (queue.size() > 0) {
            for (int i = 0; i < queue.size(); i++) {
                int curr = queue.poll();
                if(curr-1 >= 1 && !vis[curr-1]) {
                    vis[curr-1] = true;
                    queue.add(curr-1);
                }

                if(curr+1 <= n && !vis[curr-1]) {
                    vis[curr+1] = true;
                    queue.add(curr+1);
                }
            }
            time++;
        }

        System.out.println(time-1);
    }

    public static void main(String[] args) {
        /*
         * We have an integer N which denotes the number of slots, 
         * and an array arr[] consisting of K integers in the range[1,N]
         * reprehend.Each element of the array are in the range[1,N] which
         * represents the indices of the filled slots.At each unit of time,
         * the index with filled slot fills the adjacent empty slots. 
         * The task is to find the minimum time taken to fill all the N slots.
         */

        int arr[] = {1, 2, 3, 4, 5};
        int n = 5;
        int k = arr.length;
        minTime(arr, n, k);
    }
}

package Hash;
import java.util.HashMap;

public class HashMap_SubArray_Sum_Equal_K {     // O(n)
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};  
        int k = -10;
        // sum[0, j] - sum[0, i-1] = sum[i, j]
        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum, count)
        map.put(0, 1);

        int sum = 0, ans = 0;

        for (int j = 0; j < arr.length; j++) {  
            sum += arr[j];
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);
    }
}

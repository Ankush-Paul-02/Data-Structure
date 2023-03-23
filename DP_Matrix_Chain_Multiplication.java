public class DP_Matrix_Chain_Multiplication {

    public static int mcm_recursion(int arr[], int i, int j) {
        if(i == j) return 0;
        int answer = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int cost1 = mcm_recursion(arr, i, k);   //? Ai....Ak => arr[i-1] x arr[k]
            int cost2 = mcm_recursion(arr, k+1, j); //? Ak+1....Aj => arr[k] x arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            answer = Math.min(answer, finalCost);
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        System.out.println(mcm_recursion(arr, 1, n-1));
    }
}

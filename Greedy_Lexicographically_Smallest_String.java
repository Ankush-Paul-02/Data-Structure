import java.util.*;

public class Greedy_Lexicographically_Smallest_String {
    public static char[] lexo_small(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');

        for (int i = n-1; i >= 0; i--) {
            k -= i;
            if(k >= 0) {
                if(k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } else {
                    arr[i] = (char)(k+97-1);
                    k -= arr[i] - 'a' + 1;
                }
            } else {
                break;
            }
            k += i;
        }
        return arr;
    }
    public static void main(String[] args) {
        /*
         * We have two integers N and K.The task is to print the lexicographically
         * smallest string of length N consisting of lower-case English alphabets
         * such that the sum of the characters of the string equals to K where
         * ‘a’ = 1, ‘b’ = 2, ‘c’ = 3, ..... and ‘z’ = 26
         */
        int n = 5, k = 42;
        char arr[] = lexo_small(n, k);
        System.out.println(new String(arr));
    }
}

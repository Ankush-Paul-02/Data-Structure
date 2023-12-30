package Array;
public class Array_Unique_Element {
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 6, 3, 6, 2};
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans^arr[i];
        }
        System.out.println(ans);
    }
}

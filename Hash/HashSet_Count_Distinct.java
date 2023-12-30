package Hash;
import java.util.HashSet;

public class HashSet_Count_Distinct {
    public static void main(String[] args) {
        int num[] = {4, 2, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> distinct = new HashSet<>();

        for (int i = 0; i < num.length; i++) {
            distinct.add(num[i]);
        }

        System.out.println(distinct.size());
    }
}

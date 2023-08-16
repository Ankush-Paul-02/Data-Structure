import java.util.*;

public class ArrayList3Sum {

    //! O(n^2 * size of set)
    public static List<List<Integer>> find1(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set2 = new HashSet<>();
            for (int j = i+1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (set2.contains(third)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(third);
                    Collections.sort(list);
                    set.add(list);
                }
                set2.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    //! O(n*logn + near about n^2)
    public static List<List<Integer>> find2(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            //? If its not the first element and its equivalent to neighbor then continue
            if (i > 0 && (nums[i] == nums[i-1])) continue;

            int j = i+1, k = n-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum  < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> trp = new ArrayList<>();
                    trp.add(nums[i]);
                    trp.add(nums[j]);
                    trp.add(nums[k]);
                    ans.add(trp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, 4};
        System.out.println(find2(nums));
    }
}

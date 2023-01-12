import java.util.*;

class HashMap_Two_Sum {    

    public static int[] twoSum(int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // difference = given target - number given at ith index
            int diff = target - arr[i];

            // check if found difference is present in the map
            if(map.containsKey(diff)) {
                // if difference in map matches with the ith index element in array
                return new int[] {i, map.get(diff)};
            }
            // add arr element i map to match with future element if forms a pair
            map.put(arr[i], i);
        }
        // if no matches are found
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;

        int res[] = twoSum(arr, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
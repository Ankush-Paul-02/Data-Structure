package Array;
import java.util.ArrayList;
public class ArrayList_PairSum {

    /*
     * Find if any pair in a Sorted ArrayList has a target sum
     * list = [1, 2, 3, 4, 5, 6], target = 5
     */

    public static boolean pairSum1(ArrayList<Integer> list, int target) {   // O(n)
        int lp = 0;
        int rp = list.size()-1;
        while(lp < rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    /*
     * Find if any pair in a Sorted & Rotated ArrayList has a target sum.
     * list = [11, 15, 6, 8, 9, 10], target = 16;
     */

    public static boolean pairSum2(ArrayList<Integer> list, int target) {   // O(n)
        int breakingPoint = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > list.get(i+1)) {
                breakingPoint = i;
                break;
            }
        }
            int lp = breakingPoint+1; // smallest
            int rp = breakingPoint; // largest

            while(lp != rp) {
                if(list.get(lp) + list.get(rp) == target) {
                    return true;
                } else if(list.get(lp) + list.get(rp) < target) {
                    lp = (lp+1)%n;
                } else {
                    rp = (rp+n-1)%n;
                }
            }
            return false;
    }
     
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target1 = 5;
        System.out.println(pairSum1(list, target1));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(15);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        int target2 = 16;
        System.out.println(pairSum2(list2, target2));

    }
}

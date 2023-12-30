package Array;
import java.util.ArrayList;

public class ArrayList_Container_Most_Water {

    // using 2 pointer approach
    public static int storeWater(ArrayList<Integer> height) {   // O(n)
        int maximumWater = Integer.MIN_VALUE;
        int lp = 0, rp = height.size()-1;

        while(lp < rp) {
            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp;
            int currentWater = h*w;
            maximumWater = Math.max(maximumWater, currentWater);

            if(height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maximumWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(storeWater(list));
    }
}

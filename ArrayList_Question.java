import java.util.*;;
public class ArrayList_Question {

    public static boolean isMonotonic(ArrayList<Integer> list) {
        boolean isInc = true;
        boolean isDec = true;

        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)) {
                isInc = false;
            }
            if(list.get(i) < list.get(i+1)) {
                isDec = false;
            }
        }
        return isDec || isInc;
    }

    public static void lonelyNumber(ArrayList<Integer> l) {
        Collections.sort(l);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < l.size()-1; i++) {
            if(l.get(i-1)+1 < l.get(i) && l.get(i)+1 < l.get(i+1)) {
                list.add(l.get(i));
            }
        }
        if(l.size() == 1) {
            list.add(l.get(0));
        }
        if(l.size() > 1) {
            if(l.get(0) + 1 < l.get(1)) {
                list.add(l.get(0));
            }
            if(l.get(l.size()-2) + 1 < l.get(l.size()-1)) {
                list.add(l.get(l.size()-1));
            }
        }
        System.out.println(list);
    }

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.size()-1; i++) {
            if(nums.get(i) == key) {
                list.add(nums.get(i));
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
                ans = i+1;
            }
        }
        return ans;
    }

    public static void beautifulArrayList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer e : list) {
                if(2*e <= n) {
                    temp.add(e*2);
                }
            }
            for (Integer e : list) {
                if(2*e-1 <= n) {
                    temp.add(e*2-1);
                }
            }
            list = temp;
        }
        System.out.println(list);
    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);
        System.out.println(isMonotonic(list1));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(6);
        list2.add(5);
        list2.add(8);
        lonelyNumber(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(2);
        list3.add(2);
        list3.add(2);
        list3.add(3);
        System.out.println(mostFrequent(list3, 2));

        beautifulArrayList(4);
    }
}

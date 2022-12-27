public class Greedy_Kth_Largest_Odd_Num {

    public static int kThOdd(int range[], int k) {
        if(k <= 0) {
            return 0;
        }
        int L = range[0];
        int R = range[1];

        if((R & 1) > 0) {
            int count = (int)Math.ceil((R-L+1)/2);
            if(k > count) {
                return 0;
            } else {
                return (R-2*k+2);
            }
        } else {
            int count = (R-L+1)/2;
            if(k > count) {
                return 0;
            } else {
                return (R-2*k+2);
            }
        }
    }
    public static void main(String[] args) {
        /*
         *  We have two variables L and R indicating a range of integers
         *  from L to R inclusive, and a number K, the task is to find
         *  Kth largest odd number. If K > number of odd numbers in the range 
         *  L to R then return 0.
         */

        int range[] = {-3, 3};
        System.out.println(kThOdd(range, 1));
    }
}

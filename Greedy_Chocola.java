import java.util.Arrays;
import java.util.Collections;

public class Greedy_Chocola {
    public static void main(String[] args) {
        /*
         *  We are given a bar of chocolate composed of mXn square pieces.
         *  One should break the chocolate int single squares. Each breal
         *  of a part of chocolate is charged a cost expressed by a positive \
         *  integer. This cost doesn't depend on the size of the part that is 
         *  being broken but only depends on the line the break goes along.
         *  Let us denote the costs of breaking along consecutive vertical
         *  lines with x1, x2,...,xm-1 and along horizontal lines with
         *  y1, y2,..., yn-1.
         *  Compute the minimal cost of breaking the whole chocolate into
         *  the single squares.  
         */

        Integer costVer[] = {2, 1, 3, 1, 4};    // m-1
        Integer costHor[] = {4, 1, 2};  // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int hc = 0, vc = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (hc < costHor.length && vc < costVer.length) {
            // vertical cost < horizontal cost
            if(costHor[hc] >= costVer[vc]) {    // Horizontal cut
                cost += (costHor[hc]*vp);
                hp++;
                hc++;
            } else {    // vertical cut
                cost += (costVer[vc]*hp);
                vp++;
                vc++;
            }
        }
        while(hc < costHor.length) {
            cost += (costHor[hc]*vp);
            hp++;
            hc++;
        }
        while(vc < costVer.length) {
            cost += (costVer[vc]*hp);
            vp++;
            vc++;
        }

        System.out.println("Minimum cost of cuts : " + cost);
    }
}

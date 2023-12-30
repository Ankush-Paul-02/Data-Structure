package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Greedy_Activity_Selection {
    public static void main(String[] args) {    // O(nlog(n))
        /*
         *  You are given n activities with their start and end times.
         * Select the maximum number of activities that can be performed
         * by a single person, assuming that a person can only work on a 
         * single activity at a time. Activities are sorted according to 
         * wnd time.
         */

        int startTime[] = {1, 3, 0, 5, 8, 5};
        int endTime[] = {2, 4, 6, 7, 9, 9};

        // sorting
        int activities[][] = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            activities[i][0] = i;
            activities[i][1] = startTime[i];
            activities[i][2] = endTime[i];
        }

        // lamda function -> shortform of big function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // already end time basis sorted
        int maximumActivity = 0;
        ArrayList<Integer> result = new ArrayList<>();

        // 1st activity
        maximumActivity = 1;
        result.add(activities[0][0]);
        int lastEndTime = activities[0][2];
        for (int i = 1; i < endTime.length; i++) {
            if(activities[i][1] >= lastEndTime) {
                // activity selected
                maximumActivity++;
                result.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }
        System.out.println("Maximum activities : " + maximumActivity);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("A" + result.get(i) + " ");
        }
    }
}
import java.util.ArrayList;
import java.util.Collections;

public class Greedy_Job_Sequencing {

    public static class Job {
        int deadline;
        int profit;
        int id; // 0(A), 1(B),... 

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        /*
         * Given an array of jobs where every job has a deadline and 
         * profit if the job is finished before the deadline. It is also
         * given that every job takes a single unit of time, so the 
         * minimum possible deadline for any job is 1. Maximize the total 
         * profit if only one job can be scheduked at a time.
         * 
         * Job A = 4, 20
         * Job B = 1, 10
         * Job C = 1, 40        ans = C, A
         * Job D = 1, 30
         */
        
        int jobsInfo[][] = 
        {
            {4, 20},
            {1, 10},    // {deadline, profit}
            {1, 40},
            {1, 30}
        };

        ArrayList<Job> jobs = new ArrayList<>();    // Convert jobs information to object

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);    // decending order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job currJob = jobs.get(i);
            if(currJob.deadline > time) {
                seq.add(currJob.id);
                time++;
            }
        }

        System.out.println("Max Jobs: " + time);
        System.out.println(seq);
    }
}

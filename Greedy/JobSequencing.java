// retunr count  , totalProfit
import java.util.*;
class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        // Step 1: create job list
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(i + 1, deadline[i], profit[i]));
        }

        // Step 2: sort by profit descending
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 3: find max deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 4: slot array
        boolean[] slot = new boolean[maxDeadline];

        int count = 0;
        int totalProfit = 0;

        // Step 5: assign jobs
        for (Job curr : jobs) {
            for (int t = curr.deadline - 1; t >= 0; t--) {
                if (!slot[t]) {
                    slot[t] = true;
                    count++;
                    totalProfit += curr.profit;
                    break;
                }
            }
        }

        // Step 6: result
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);

        return ans;
    }
}





// apna college return only id
public class JobSequencing {
  class Job{
    int id;
    int deadline;
    int profit;
    public Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        //step 1:create job array
        int n = deadline.length;
        ArrayList<Job>jobs = new ArrayList<>();
        for(int i = 0; i<n; i++){
            jobs.add(new Job(i, deadline[i], profit[i]));
        }
        
       //step 2: sort profit by descending order
        Collections.sort(jobs, (a, b) ->b.profit - a.profit);
        
        ArrayList<Integer>seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }
        
        for(int i= 0; i<seq.size(); i++){
            System.out.println(seq.get(i));
        }
        
        
    }
}
}

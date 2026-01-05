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

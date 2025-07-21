class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        List<Job> jobs = new ArrayList<>();
        int daysSize = 0;
        for(int i=0;i<n;i++){
            daysSize = Math.max(daysSize, deadline[i]);
            Job job = new Job(deadline[i], profit[i]);
            jobs.add(job);
        }
        int[] isOccupied = new int[daysSize+1];
        Arrays.fill(isOccupied,-1);
        int cnt = 0;
        int maxProfit = 0;
        Collections.sort(jobs, new SortTheJobs());
        for(int i=0;i<n;i++){
            Job job = jobs.get(i);
            for(int j=job.deadLine-1;j>=0;j--){
                if(isOccupied[j] == -1){
                    isOccupied[j] = i;
                    maxProfit += job.profit;
                    cnt++;
                    break;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(cnt);
        res.add(maxProfit);
        return res; 
    }
    
}

class Job{
    int deadLine;
    int profit;
    Job(int deadLine, int profit){
        this.deadLine = deadLine;
        this.profit = profit;
    }
}

class SortTheJobs implements Comparator<Job> {
    public int compare(Job j1, Job j2){
        return j2.profit - j1.profit;
    }
}
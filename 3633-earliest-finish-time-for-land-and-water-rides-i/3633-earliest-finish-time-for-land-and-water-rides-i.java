class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans  = Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            int time1 = landStartTime[i] + landDuration[i];
            for(int j = 0;j<waterDuration.length;j++){
                int nxtStartTime = Math.max(0, waterStartTime[j] - time1);
                int finalTime = time1 +(nxtStartTime + waterDuration[j]);
                ans = Math.min(ans, finalTime);
            }
        }

        for(int i=0;i<waterStartTime.length;i++){
            int time1 = waterStartTime[i] + waterDuration[i];
            for(int j = 0;j<landDuration.length;j++){
                int nxtStartTime = Math.max(0, landStartTime[j] - time1);
                int finalTime = time1 +(nxtStartTime + landDuration[j]);
                ans = Math.min(ans, finalTime);
            }
        }

        return ans;
    }
}
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0;
        int n = neededTime.length;
        int ans = 0;
        while(i < n){
            if(i+1 < n && colors.charAt(i) == colors.charAt(i+1)){
                int maxTime = neededTime[i];;
            int curr = neededTime[i];
            while(i+1 < n && colors.charAt(i) == colors.charAt(i+1)){
                maxTime = Math.max(maxTime,neededTime[i+1]);
                curr += neededTime[i+1];
                i++;
            }
            ans += curr - maxTime;
            }else{
                i++;
            }
            
        }
        return ans;
    }
}
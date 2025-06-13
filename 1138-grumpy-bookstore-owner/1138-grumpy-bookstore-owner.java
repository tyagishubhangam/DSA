class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int l = 0;
        int j = minutes;
        int nonSat = 0;
        
        for(int i=0;i<minutes;i++){
            if(grumpy[i] == 1){
                nonSat += customers[i];
            }
        }
        int maxNonSat = nonSat;
        while(j<n){
            if(grumpy[j] == 1){
                nonSat += customers[j];
            }
            if(grumpy[l] == 1){
                nonSat -= customers[l];
            }

            maxNonSat = Math.max(maxNonSat, nonSat);
            System.out.println(nonSat);
            l++;
            j++;
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(grumpy[i] == 0){
                ans += customers[i];
            }
        }
        return ans + maxNonSat;
    }
}
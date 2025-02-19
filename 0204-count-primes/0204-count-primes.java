class Solution {
    public int countPrimes(int n) {
        if(n <=1){
            return 0;
        }
        int[] primeStats = new int[n];
        
        for(int i=1;i<n;i++){
            primeStats[i] = 1;
            
        }
        primeStats[1] = 0;
        for(int i=2;i*i < n;i++){
            // System.out.println(i);
            if(primeStats[i] == 1){
                
                for(int j=i;i*j < n;j++){
                    // System.out.println(i*j);
                    primeStats[i*j] = 0;
                }
            }
        }
        int cnt = 0;
        for(int i=1;i<n;i++){
            if(primeStats[i] == 1){
                // System.out.println(i);
                cnt += 1;
            }
        }
        return cnt;
    }
}
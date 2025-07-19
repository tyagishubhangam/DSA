// User function Template for Java

class Solution {
    static List<Integer> minPartition(int N) {
        // code here
        List<Integer> res = new ArrayList<>();
        int[] curr = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        for(int i=curr.length - 1;i>=0;i--){
            int coins = N / curr[i];
            N = N - (N / curr[i]) * curr[i];
            for(int j=0;j<coins;j++){
                res.add(curr[i]);
            }
            if(N == 0){
                break;
            }
        }
        return res;
    }
}
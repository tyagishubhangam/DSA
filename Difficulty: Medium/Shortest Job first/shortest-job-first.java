// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int waitTime = 0;
        int next = 0;
        for(int i=0;i<bt.length;i++){
            waitTime += next;
            next += bt[i];
            
        }
        return waitTime / bt.length;
    }
}

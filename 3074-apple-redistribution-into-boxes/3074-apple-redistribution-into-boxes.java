class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length;
        int m = capacity.length;
        int tot = 0;
        for(int i : apple){
            tot += i;
        }
        int cnt = 0;
        Arrays.sort(capacity);
        for(int i=m-1;i>=0;i--){
            tot -= capacity[i];
            cnt++;
            if(tot <= 0){
                return cnt;
            }
        }

        if(tot == 0){
            return cnt;
        }
        return 0;
    }
}
class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minCapacity = 101;
        int n = capacity.length;
        int res = 100;
        for(int i=0;i<n;i++){
            if(capacity[i] >= itemSize){
                if(capacity[i] < minCapacity){
                    minCapacity = capacity[i];
                    res = i;
                }
            }
        }

        return res == 100 ? -1 : res;
    }
}
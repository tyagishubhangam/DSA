class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int idx = binarySearch(potions, spells[i], success);
            if(idx < m){
                ans[i] = m - idx;
            }
        }
        return ans;

    }

    public int binarySearch(int[] potions, int spell, long k){
        int m = potions.length;
        int l = 0;
        int r = m - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            long req = (long)potions[mid] * spell;
            if(req >= k){
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }
        return l;
    }
}
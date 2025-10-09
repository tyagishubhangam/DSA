class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] tmp = new long[n];
        for(int i=0;i<m;i++){
            tmp[0] += mana[i] * skill[0];
            for(int j=1;j<n;j++){
                tmp[j] = (long)Math.max(tmp[j-1], tmp[j]) + mana[i] * skill[j];
            }

            for(int j=n-1;j>0;j--){
                tmp[j-1] = tmp[j] - (mana[i] * skill[j]);
            }
        }
        return tmp[n-1];
    }
}
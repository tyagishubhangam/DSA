class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxRevisions = Math.max(v1.length, v2.length);
        int[] r1 = new int[maxRevisions];
        int[] r2 = new int[maxRevisions];
        for(int i=0;i<v1.length;i++){
            int x = Integer.parseInt(v1[i]);
            r1[i] = x;
        }

        for(int i=0;i<v2.length;i++){
            int y = Integer.parseInt(v2[i]);
            r2[i] = y;
        }

        for(int i=0;i<maxRevisions;i++){
            if(r1[i]<r2[i]){
                return -1;
            }
            if(r1[i] > r2[i]){
                return 1;
            }
        }

        return 0;
    }
}
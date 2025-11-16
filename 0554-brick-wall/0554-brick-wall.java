class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        int maxCommon = -(int)1e7;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0;i<n;i++){
            int sm = 0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                sm += wall.get(i).get(j);
                hs.put(sm,hs.getOrDefault(sm,0)+1);
                maxCommon = Math.max(maxCommon, hs.get(sm));
            }
        }

        if(maxCommon == -(int)1e7){
            return n;
        }

        return n - maxCommon;
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int cnt = 0;
        int maxCnt = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r < n){
            cnt += 1;
            hs.put(fruits[r], hs.getOrDefault(fruits[r], 0) + 1);
            while(hs.size() > 2){
                hs.put(fruits[l], hs.get(fruits[l]) - 1);
                cnt--;
                if(hs.get(fruits[l]) == 0){
                    hs.remove(fruits[l]);
                }
                l++;
            }
            r++;
            maxCnt = Math.max(maxCnt, cnt);
        }

        return maxCnt;
    }
}
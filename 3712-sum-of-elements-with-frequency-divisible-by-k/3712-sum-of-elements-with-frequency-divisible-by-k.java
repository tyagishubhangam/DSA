class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int ans = 0;
        for(int i : nums){
            hs.put(i, hs.getOrDefault(i, 0)+1);
        }
        for(int i : hs.keySet()){
            if(hs.get(i) % k == 0){
                ans += (i*hs.get(i));
            }
        }
        return ans;
    }
}
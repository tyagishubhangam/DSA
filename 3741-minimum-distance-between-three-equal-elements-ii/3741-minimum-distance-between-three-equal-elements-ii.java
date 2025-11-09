class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> hs = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(hs.get(nums[i]) == null){
                hs.put(nums[i], new ArrayList<>());
            }
            hs.get(nums[i]).add(i);
        }
        for(int key : hs.keySet()){
            if(hs.get(key).size() >= 3){
                ans = Math.min(ans, getDist(hs.get(key)));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;


    }

    public int getDist(List<Integer> li){
        int n = li.size();
        int ans = 2 * (Math.max(li.get(0), Math.max(li.get(1), li.get(2))) - Math.min(li.get(0), Math.min(li.get(1), li.get(2))));
        for(int i=0;i<n-2;i++){
            ans = Math.min(ans,
                2 * (Math.max(li.get(i), Math.max(li.get(i+1), li.get(i+2))) - Math.min(li.get(i), Math.min(li.get(i+1), li.get(i+2))))            
            );
        }
        return ans;
        
    }
}
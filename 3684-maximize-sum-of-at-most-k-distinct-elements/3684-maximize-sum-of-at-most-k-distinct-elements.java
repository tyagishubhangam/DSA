class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        Arrays.sort(nums);
        for(int i=n-1;i>=0;i--){
            hs.add(nums[i]);
            if(hs.size() == k){
                break;
            }
        }
        
        int[] res = new int[Math.min(k, hs.size())];
        
       int idx = 0;
       Iterator<Integer> itr = hs.iterator();
       while(itr.hasNext()){
        res[idx] = itr.next();
        idx++;
       }
       Arrays.sort(res);
       for(int i=0;i<res.length/2;i++){
            int tmp = res[i];
            res[i] = res[res.length - i - 1] ;
            res[res.length - i - 1] = tmp;
       }

        return res;
    }
}
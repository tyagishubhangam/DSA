class Solution {
    public List<Integer> targetIndices(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int fo = -1;
        int lo = -1;
        while(l<=r){
            int mid = (l + r) / 2;
            if(nums[mid] == k){
                if(mid == 0){
                    fo = 0;
                    break;
                }else{
                    if(nums[mid-1] != k){
                        fo = mid;
                        break;
                    }else{
                        r = mid - 1;
                    }
                }
            }else{
                if(nums[mid] > k){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }
        }
        l = 0;
        r = nums.length - 1;
        while(l<=r){
            int mid = (l + r) / 2;
            if(nums[mid] == k){
                if(mid == nums.length - 1){
                    lo = nums.length - 1;
                    break;
                }else{
                    if(nums[mid + 1] != k){
                        lo = mid;
                        break;
                    }else{
                        l = mid + 1;
                    }
                }
            }else{
                if(nums[mid] > k){
                    r = mid -1 ;

                }else{
                    l = mid +1 ;
                }
            }
        }
        if(fo == -1){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        // int idx = 0;
        for(int i=fo;i<=lo;i++){
            ans.add(i);
            
        }
        return ans;
    }
}
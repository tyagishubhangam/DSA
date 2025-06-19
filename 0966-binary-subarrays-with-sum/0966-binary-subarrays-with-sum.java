class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int count_zeros = 0;
        int l = 0;
        int r = 0;
        int windowSum = 0;
        int ans = 0;
        while(r<n){
            windowSum += nums[r];
            while(l<r && (nums[l] == 0 || windowSum > goal)){
                if(nums[l] == 0){
                    count_zeros++;
                }else{
                    count_zeros = 0;
                }
                windowSum -= nums[l];
                l++;
            }
            if(windowSum == goal){
                ans += 1 + count_zeros;
            }
            r++;
        }
        return ans;
    }
}

// isme window jab zero start hori hai tab humm dekh sakte hai ki hum uske no. of zeros ko count karke left pointer ko aage badha sakte hai and then ans mei add kar sakte hai no. of zeros ko agar window SUm abhi bhi valid hai

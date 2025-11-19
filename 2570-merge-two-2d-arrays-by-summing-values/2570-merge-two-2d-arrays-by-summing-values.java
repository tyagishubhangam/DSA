class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int[] num : nums1){
            hs.put(num[0], hs.getOrDefault(num[0], 0)+num[1]);
        }
        for(int[] num : nums2){
            hs.put(num[0], hs.getOrDefault(num[0], 0)+num[1]);
        }
        int[][] ans = new int[hs.size()][2];
        int idx = 0;
        while(l < n && r < m){
            if(nums1[l][0] == nums2[r][0]){
                ans[idx][0] = nums1[l][0];
                ans[idx][1] = nums1[l][1] + nums2[r][1];
                l++;
                r++;
            }else{
                if(nums1[l][0] < nums2[r][0]){
                    ans[idx][0] = nums1[l][0];
                    ans[idx][1] = nums1[l][1];
                    l++;
                }else{
                    ans[idx][0] = nums2[r][0];
                    ans[idx][1] = nums2[r][1];
                    r++;
                }
            }

            idx++; 
        }

        while(l < n){
            ans[idx][0] = nums1[l][0];
            ans[idx++][1] = nums1[l][1];
            l++;
        }
        while(r < m){
            ans[idx][0] = nums2[r][0];
            ans[idx++][1] = nums2[r][1];
            r++;
        }

        return ans;

    }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0;
        int r = 0;
        int[] tmp = new int[m];
        for(int i=0;i<m;i++){
            tmp[i] = nums1[i];
        }
        int idx = 0;
        while(l < m && r < n){
            if(tmp[l] <= nums2[r]){
                nums1[idx] = tmp[l];
                l++;
            }else{
                nums1[idx] = nums2[r];
                r++;
            }
            idx++;
        }
        while(l < m){
            nums1[idx] = tmp[l];
                l++;
                idx++;
        }
        while(r < n){
            nums1[idx] = nums2[r];
                r++;
                idx++;
        }
    }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res[] = new int[n+m];
        int r=0,l=0,i=0;
        while(l<m && r<n){
            if(nums1[l]<=nums2[r]){
                res[i] = nums1[l];
                l++;
            }else{
                res[i] = nums2[r];
                r++;
            }
            i++;
        }
        while(l<m){
            res[i] = nums1[l];
            l++;
            i++;
        }
        while(r<n){
            res[i] = nums2[r];
            r++;
            i++;
        }
        for(int k=0;k<m+n;k++){
            
                nums1[k] = res[k];
            
        }
    }
}
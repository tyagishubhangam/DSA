class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while(l < r){
            int currArea = (r-l) * Math.min(height[l], height[r]);
            res = Math.max(res, currArea);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
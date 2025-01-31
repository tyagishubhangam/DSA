class Solution {
    public int trap(int[] height) {
        int[] maxHeightLeft = new int[height.length];
        int[] maxHeightRight = new int[height.length];
        maxHeightLeft[0] = height[0];
        for(int i=1;i<height.length;i++){
            maxHeightLeft[i] = Math.max(maxHeightLeft[i-1], height[i]);
        }
        maxHeightRight[height.length - 1] = height[height.length - 1];
        for(int i=height.length-2; i>=0;i--){
            maxHeightRight[i] = Math.max(maxHeightRight[i+1], height[i]);
        }
        int totalHeight = 0;
        for(int i=1;i<height.length - 1;i++){
            int minHeight = Math.min(maxHeightLeft[i-1], maxHeightRight[i+1]);
            if(minHeight > height[i]){
                totalHeight += minHeight - height[i];
            }
        }
        return totalHeight;
    }
}
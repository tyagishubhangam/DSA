class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftHeights = new int[n];
        int[] rightHeights = new int[n];
        leftHeights[0] = height[0];
        rightHeights[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            leftHeights[i] = Math.max(height[i], leftHeights[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rightHeights[i] = Math.max(height[i], rightHeights[i+1]);
        }
        int totHeight = 0;
        for(int i=1;i<n-1;i++){
            int tmp = Math.min(rightHeights[i+1],leftHeights[i-1]);
            if(tmp > height[i]){
                totHeight += tmp - height[i];
            }
        }
        return totHeight;
    }
}
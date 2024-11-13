class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<k;i++){
            leftSum += cardPoints[i];
        }
        int maxPoints = leftSum;
        int leftPointer = k-1;
        int rightPointer = cardPoints.length -1;
        for(int i=1;i<=k;i++){
            leftSum -= cardPoints[leftPointer];
            rightSum += cardPoints[rightPointer];
            maxPoints = Math.max(leftSum + rightSum, maxPoints);
            leftPointer--;
            rightPointer--;
        }
        return maxPoints;
    }
}
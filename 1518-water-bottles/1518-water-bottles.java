class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int cnt = numBottles;
        while(emptyBottles >= numExchange){
            int replaced = emptyBottles / numExchange;
            cnt += replaced;
            emptyBottles = replaced + emptyBottles % numExchange;
        }
        return cnt;

    }
}
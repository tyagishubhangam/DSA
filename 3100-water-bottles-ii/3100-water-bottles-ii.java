class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            drunk += 1;
            empty += 1;
            empty -= numExchange;
            numExchange++;
        }

        return drunk;
        
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Pair> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            Pair tmp = new Pair(position[i],(double)(target-position[i])/speed[i] );
            li.add(tmp);
        }
        Collections.sort(li, new SortByPositions());
        int fleet = 0;
        double prevTime = 0;
        for(int i=0;i<n;i++){
            double currTime = li.get(i).time;
            if(prevTime < currTime){
                fleet++;
                prevTime = currTime;
            }
        }
        return fleet;
    }
}

class Pair{
    int pos;
    double time;
    Pair(int pos, double time){
        this.pos = pos;
        this.time = time;
    }
}

class SortByPositions implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p2.pos - p1.pos;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> li = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            Car c = new Car(position[i],(double)(target - position[i])/speed[i]);
            li.add(c);
        }

        Collections.sort(li, new CustomSort());

        double mx = -1;
        int ans = 0;
        for(Car i:li){
            // System.out.print(i.pos+" "+i.time+" ");
            if(mx < i.time){
                ans++;
                mx = i.time;
            }
        }

        return ans;
    }
}

class Car {
    int pos;
    
    double time;

    Car(int pos, double time){
        this.pos = pos;
        
        this.time = time;
    }
}

class CustomSort implements Comparator<Car>{
    public int compare(Car a, Car b){
        return b.pos - a.pos;
    }
}
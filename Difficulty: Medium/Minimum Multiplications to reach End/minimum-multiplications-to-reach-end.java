// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int[] minSteps = new int[(int)1e5];
        Arrays.fill(minSteps, (int)1e9);
        minSteps[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new SortThePQ());
        pq.add(new Pair(0,start));
        
        while(!pq.isEmpty()){
            Pair tmp = pq.poll();
            int stps = tmp.steps;
            int n = tmp.num;
            for(int i=0;i<arr.length;i++){
                int nn = (n * arr[i]) % 100000;
                if(stps+1 < minSteps[nn]){
                    if(nn == end){
                        return stps + 1;
                    }
                    minSteps[nn] = stps+1;
                    pq.add(new Pair(minSteps[nn],nn));
                }
            }
        }
        
        if(minSteps[end] == (int)1e9){
            return -1;
        }
        return minSteps[end];
    }
}

class Pair{
    int steps;
    int num;
    Pair(int steps, int num){
        this.steps = steps;
        this.num = num;
    }
}

class SortThePQ implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return a.steps - b.steps;
    }
}


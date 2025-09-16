class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        List<double[]> li = new ArrayList<>();

        for(int i=0;i<n;i++){
            double ratio = (double)wage[i] / quality[i];
            li.add(new double[]{ratio, (double)quality[i]});
        }

        Collections.sort(li, (a, b)-> Double.compare(a[0], b[0]));
        double sm = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)-> Double.compare(b, a));
        for(int i=0;i<k;i++){
            pq.offer(li.get(i)[1]);
            sm += li.get(i)[1];
            
        }
        double minCost = Double.MAX_VALUE;
        minCost = Math.min(minCost, sm * li.get(k-1)[0]);
        for(int i = k;i<n;i++){
            
            sm += li.get(i)[1];
            sm -= pq.poll();
            minCost = Math.min(minCost, sm * li.get(i)[0]);
            pq.offer(li.get(i)[1]);


        }

        return minCost;
    }
}
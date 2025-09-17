class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int m = people.length;
        List<int[]> janta = new ArrayList<>();
        for(int i=0;i<m;i++){
            janta.add(new int[]{people[i], i});
        }
        Arrays.sort(flowers, (a,b)->a[0] - b[0]);
        Collections.sort(janta, (a,b)->a[0] - b[0]);
        int[] ans = new int[m];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a - b);
        int idx = 0;
        for(int i=0;i<m;i++){
            int currPerson = janta.get(i)[0];
            while(idx < n){
                if(flowers[idx][0] <= currPerson){
                    pq.offer(flowers[idx][1]);
                    idx++;
                }else{
                    break;
                }
            }
            while(!pq.isEmpty() && pq.peek() < currPerson){
                pq.poll();
            }
            ans[janta.get(i)[1]] = pq.size();
        }
        

        return ans;
    }
}


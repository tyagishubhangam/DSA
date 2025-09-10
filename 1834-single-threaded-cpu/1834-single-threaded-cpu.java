class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] tasksWithIndex = new int[n][3];
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            tasksWithIndex[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasksWithIndex, new SortTheTasks());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortThePQ());
        int idx = 0;
        // pq.offer(tasksWithIndex[0]);
        int i = 0;
        int curr_time = 0;
        while(i < n || !pq.isEmpty() ){
            if(pq.isEmpty() && curr_time < tasksWithIndex[i][0]){
                curr_time = tasksWithIndex[i][0];
            }

            while(i < n && tasksWithIndex[i][0] <= curr_time){
                pq.offer(tasksWithIndex[i]);
                i++;
            }
            int[] curr_task = pq.poll();
            curr_time += curr_task[1] ;
            result[idx++] = curr_task[2];
        }
        return result;
    }
}

class SortTheTasks implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        if(a[0] == b[0]){
            return a[1] - b[1];
        }
        return a[0] - b[0];
    }
}

class SortThePQ implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        if(a[1] == b[1]){
            return a[2] - b[2];
        }
        return a[1] - b[1];
    }
}
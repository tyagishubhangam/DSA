class Solution {
    public int earliestTime(int[][] tasks) {
        int min = tasks[0][0] + tasks[0][1];
        for(int[] task : tasks){
            min = Math.min(task[0]+task[1], min);
        }

        return min;
    }
}
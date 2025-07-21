class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        List<int[]> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] pair = new int[]{start[i], end[i]};
            li.add(pair);
        }
        Collections.sort(li, new SortTheMeetings());
        int cnt = 1;
        int prevEnd = li.get(0)[1];
        for(int i = 1;i<n;i++){
            if(li.get(i)[0] > prevEnd){
                cnt += 1;
                prevEnd = li.get(i)[1];
            }
            
        }
        return cnt;
    }
}

class SortTheMeetings implements Comparator<int[]>{
    public int compare(int[] p1, int[] p2){
        if(p1[1] == p2[1]){
            return p1[0] - p2[0];
        }
        return p1[1] - p2[1];
        
    }
}

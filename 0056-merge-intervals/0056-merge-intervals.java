class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new SortIntervals());
        List<List<Integer>> merged = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(intervals[0][0]);
        tmp.add(intervals[0][1]);
        merged.add(tmp);
        for(int i=1;i<intervals.length;i++){
            int idx = merged.size() - 1;
            int up = merged.get(idx).get(1);
            int low = intervals[i][0];
            tmp = new ArrayList<>();
            if(up >= low){
                
                tmp.add(merged.get(idx).get(0));
                tmp.add(Math.max(intervals[i][1], merged.get(idx).get(1)));
                merged.set(idx,tmp);
            }else{
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);
                merged.add(tmp);
            }
        }
        // System.out.println(merged);
        int[][] ans = new int[merged.size()][2];
        int i=0;
        for(List l:merged){
            int[] t = new int[2];
            t[0] =  (int)l.get(0);
            t[1] = (int)l.get(1);
            ans[i] = t;
            i++;
        }
        return ans;

    }
}

class SortIntervals implements Comparator<int[]>{
    public int compare(int[] arr1, int[] arr2){
        return arr1[0] - arr2[0];
    }
}
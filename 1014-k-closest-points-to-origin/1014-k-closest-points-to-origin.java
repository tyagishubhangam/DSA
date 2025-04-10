class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Data[] tmp = new Data[points.length];
        for(int i=0;i<points.length;i++){
            int[] cc = points[i];
            Data dt = new Data(cc,getDist(cc[0],cc[1]));
            tmp[i] = dt;

        }
        Arrays.sort(tmp, new SortByDistance());
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = tmp[i].idxs;
        }
        return ans;
    }

    public static int getDist(int x, int y){
        return (x*x) +(y*y);
    }

    
}

class Data{
    int[] idxs ;
    int dist;

    Data(int[] idxs, int dist){
        this.idxs = idxs;
        this.dist = dist;
    }
}

class SortByDistance implements Comparator<Data>{
    public int compare(Data d1, Data d2){
        return d1.dist - d2.dist;
    }
}
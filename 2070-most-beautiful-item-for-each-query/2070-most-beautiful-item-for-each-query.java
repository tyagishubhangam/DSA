class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        List<Pair> li = new ArrayList<>();
        for(int[] item : items){
            li.add(new Pair(item[0], item[1]));
        }
        Collections.sort(li, new SortTheList());
        for(int i=1;i<li.size();i++){
            li.get(i).beauty = Math.max(li.get(i-1).beauty, li.get(i).beauty);
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = getBeauty(li, queries[i]);
        }

        return ans;

    }

    public int getBeauty(List<Pair> li, int k){
        int l = 0;
        int r = li.size()-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int midPrice = li.get(mid).price;
            if(midPrice <= k){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(r < 0){
            return 0;
        }

        return li.get(r).beauty;
    }
}

class Pair{
    int price;
    int beauty;
    Pair(int price, int beauty){
        this.price = price;
        this.beauty = beauty;
    }
}

class SortTheList implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.price == p2.price){
            return p1.beauty - p2.beauty;
        }

        return p1.price - p2.price;
    }
}
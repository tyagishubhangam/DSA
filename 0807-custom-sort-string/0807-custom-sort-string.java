class Solution {
    public String customSortString(String order, String s) {
        List<Data> tmp = new ArrayList<>();
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i=0;i<order.length();i++){
            hs.put(order.charAt(i),i);
        }

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int x = hs.get(ch) != null?hs.get(ch):Integer.MAX_VALUE;
            Data dt = new Data(ch,x);
            tmp.add(dt);
        }

        Collections.sort(tmp,new SortByOrder());
        String res = "";
        for(int i=0;i<s.length();i++){
            res += tmp.get(i).ch;
        }
        return res;

    }

}

class Data{
    char ch;
    int od;
    Data(char ch, int od){
        this.ch = ch;
        this.od = od;
    }
}

class SortByOrder implements Comparator<Data>{
    public int compare(Data d1, Data d2){
        return d1.od - d2.od;
    }
}
class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> li = new ArrayList<>();
        int start = -1;
        int end = -1;
        int cnt = 0;
        int total = 0;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i) == 'S'){
                cnt++;
                total++;
                if(cnt == 2){
                start = i;
            }else{
                if(cnt == 3){
                    li.add(i - start);
                    start = i;
                    cnt = 1;
                }
            }
            }
            
        }
        // System.out.println(li);
        if(total == 0 || total % 2 != 0){
            return 0;
        }
        int m = 1000000007;
        long ans = 1;
        for(int i=0;i<li.size();i++){
            ans = ((ans %m)*(li.get(i)%m))%m;
        }

        return (int)ans;
    }
}
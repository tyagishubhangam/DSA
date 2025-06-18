class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String tmp = s + s;
        int ans = n + n + n;
        int startWithZero = 0;
        int startWithOne = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(i % 2 == 0){
                if(ch != '0'){
                    startWithZero += 1;
                }else{
                    startWithOne += 1;
                }
                
            }else{
                if(ch != '1'){
                    startWithZero += 1;
                }else{
                    startWithOne += 1;
                }
            }
        }

        int l = 0;
        int r = n;
        while(r < (2*n)){
            char toRemove = tmp.charAt(l);
            char toAdd = tmp.charAt(r);

            if(l % 2 == 0){
                if(toRemove != '0'){
                    startWithZero -= 1;
                }else{
                    startWithOne -= 1;
                }
            }else{
                if(toRemove != '1'){
                    startWithZero -= 1;
                }else{
                    startWithOne -= 1;
                }
            }


            if(r % 2 == 0){
                if(toAdd != '0'){
                    startWithZero += 1;
                }else{
                    startWithOne += 1;
                }
            }else{
                if(toAdd != '1'){
                    startWithZero += 1;
                }else{
                    startWithOne += 1;
                }
            }

            ans = Math.min(ans, Math.min(startWithZero, startWithOne));
            l++;
            r++;
        }

        return ans;

    }
}
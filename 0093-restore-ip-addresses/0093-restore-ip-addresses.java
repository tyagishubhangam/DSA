class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length()>12 || s.length() < 4){
            return ans;
        }
        generateIpAddrs(0,0,"",s,ans);
        return ans;
    }

    public static void generateIpAddrs(int i, int dots,String tmp, String s, List<String> ans){
        if(i == s.length() && dots == 4){
            ans.add(tmp.substring(0,tmp.length() - 1));
            return;
        }

        if(dots > 4){
            return;
        }

        for(int j = i;j< Math.min(i+3,s.length());j++){
            String nxt = s.substring(i,j+1);
            if(nxt.length() == 1 || s.charAt(i) != '0'){
                if(Integer.parseInt(nxt) < 256){
                    generateIpAddrs(j+1,dots+1,tmp+nxt+".",s,ans);
                }
            }
        }
    }
}
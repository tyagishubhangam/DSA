class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hs = new HashMap<>();
        for(List<String> li : knowledge){
            hs.put(li.get(0), li.get(1));
        }
        int r = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int n = s.length();
        while(r < n){
            char ch = s.charAt(r);
            if(ch == '('){
                r++;
                while(s.charAt(r) != ')'){
                    sb.append(s.charAt(r));
                    r++;
                }
                
                // System.out.println(sb.toString());
                if(hs.containsKey(sb.toString())){
                    res.append(hs.get(sb.toString()));
                    
                }else{
                    res.append("?");
                }
                sb = new StringBuilder();
            }else{
                res.append(ch);
            }
            r++;
        }

        return res.toString();
    }
}
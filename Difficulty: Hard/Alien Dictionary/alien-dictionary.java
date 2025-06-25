class Solution {
    public String findOrder(String[] words) {
        // code here
        int n = words.length;
        HashMap<Character,List<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        for(int i=0;i<n;i++){
            char[] chArr = words[i].toCharArray();
            for(int j=0;j<chArr.length;j++){
                char ch = chArr[j];
                
                adj.put(ch, adj.getOrDefault(ch,new ArrayList<>()));
                inDegree.put(ch,inDegree.getOrDefault(ch,0));
            }
        }
        
        
        for(int i=0;i<n-1;i++){
            char[] x = words[i].toCharArray();
            char[] y = words[i+1].toCharArray();
            if(x.length > y.length && words[i].startsWith(words[i+1])){
                return "";
            }
            int minLen = Math.min(x.length,y.length);
            for(int j=0;j<minLen;j++){
                if(x[j] != y[j]){
                    adj.get(x[j]).add(y[j]);
                    inDegree.put(y[j],inDegree.get(y[j])+1);
                    break;
                }
            }
        }    
        Queue<Character> queue = new LinkedList<>();
        for(char c:inDegree.keySet()){
            if(inDegree.get(c) == 0){
                queue.add(c);
            }
        }
        StringBuilder res = new StringBuilder("");
        while(!queue.isEmpty()){
            char u = queue.poll();
            res.append(u);
            for(char v:adj.get(u)){
                inDegree.put(v,inDegree.get(v) - 1);
                if(inDegree.get(v) == 0){
                    queue.add(v);
                }
            }
        }
            
    
        if(res.length() == adj.size()){
                return res.toString();
            }
        return "";
    }
}
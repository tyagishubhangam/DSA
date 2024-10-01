class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i),0)+1);
        }
        // System.out.println(hs);
        List<Character>[] arr = new ArrayList[s.length()+1];

        for(char ch : hs.keySet()){
            // char ch = s.charAt(i);
            if(arr[hs.get(ch)] != null){
                arr[hs.get(ch)].add(ch);
              
            }else{
                ArrayList<Character> li = new ArrayList<>();
                li.add(ch);
                arr[hs.get(ch)] = li;
            }
        }
      for(int i=arr.length-1;i>=0;i--){
        if(arr[i]!=null){
            for(char ch : arr[i]){
                for(int j=1;j<=i;j++){
                    str.append(ch);
                }
            }
        }
      }
            return str.toString();
    }
}
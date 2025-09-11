class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if(freq[ch-'a'] > (n+1)/2){
                return "";
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->freq[b] - freq[a]);
        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                pq.offer(i);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            char first = (char)(pq.poll() + 'a');
            result.append(first);
            freq[first - 'a']--;
            if(!pq.isEmpty()){
                char second = (char)(pq.peek() + 'a');
                result.append(second);
                freq[second - 'a']--;
                if(freq[second-'a'] == 0){
                    pq.poll();
                }
            }
            if(freq[first-'a'] > 0){
                pq.offer(first - 'a');
            }
        }

        return result.toString();


        
    }
}
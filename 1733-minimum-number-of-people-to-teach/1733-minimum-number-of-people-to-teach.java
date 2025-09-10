class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int[] freq = new int[n+1];
        int maxFreq = 0;
        int mostPopLang = -1;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int[] relation : friendships){
            int u = relation[0];
            int v = relation[1];
            boolean canTalk = false;
            for(int langu : languages[u-1]){
                for(int langv : languages[v-1]){
                    if(langu == langv){
                        canTalk = true;
                        break;
                    }
                    if(canTalk){
                        break;
                    }
                }
            }
            if(!canTalk){
                hs.add(u);
                hs.add(v);
            }
        }

        for(int user : hs){
            for(int lang : languages[user-1]){
                freq[lang]++;
                if(freq[lang] > maxFreq){
                    maxFreq = freq[lang];
                }
            }
        }

        return hs.size() - maxFreq;
    }
}
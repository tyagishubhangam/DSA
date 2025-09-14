class Solution {
    public String[] spellchecker(String[] wordList, String[] queries) {
        int n = wordList.length;
        int m = queries.length;
        HashSet<String> hs = new HashSet<>();
        HashMap<String, String> sh = new HashMap<>();
        for(String wrd : wordList){
            hs.add(wrd);
            if(!sh.containsKey(wrd.toLowerCase())){

                sh.put(wrd.toLowerCase(), wrd);
            }
        }
        for(int i=0;i<m;i++){
            String query = queries[i];
            boolean checked = false;
            if(hs.contains(query)){
                
                continue;
            }
            //  case insensitive check
            if(sh.containsKey(query.toLowerCase())){
                queries[i] = sh.get(query.toLowerCase());
                continue;
            }
            // if(!checked){
            //     for(String wrd : wordList){
            //         if(wrd.equalsIgnoreCase(query)){
            //             checked = true;
            //             queries[i] = wrd;
            //             break;
            //         }
            //     }
            // }

            // Vowel check
            if(!checked){
                for(String wrd : wordList){
                    if(vowelCheck(wrd, query)){
                        checked = true;
                        queries[i] = wrd;
                        break;
                    }
                }
            }
            if(!checked){
                queries[i] = "";
            }
            
        }
        return queries;
    }

    public boolean vowelCheck(String wrd, String query){
        if(wrd.length() != query.length()){
            return false;
        }
        wrd = wrd.toLowerCase();
        query = query.toLowerCase();
        for(int i=0;i<wrd.length();i++){
            char chWrd = wrd.charAt(i);
            char chQuery = query.charAt(i);
            if(!(chWrd == chQuery) ){
                if(
                    ( chQuery == 'a' ||
                    chQuery == 'e' ||
                    chQuery == 'i' ||
                    chQuery == 'o' ||
                    chQuery == 'u' ) &&
                    (chWrd == 'a' ||
                    chWrd == 'e' ||
                    chWrd == 'i' ||
                    chWrd == 'o' ||
                    chWrd == 'u' )
                ){
                    continue;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
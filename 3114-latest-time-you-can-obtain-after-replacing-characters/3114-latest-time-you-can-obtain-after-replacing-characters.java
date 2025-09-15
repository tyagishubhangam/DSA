class Solution {
    public String findLatestTime(String s) {
        StringBuilder latestTime = new StringBuilder(s);
        if(latestTime.charAt(0) == '?'){
            if(latestTime.charAt(1) == '?' || latestTime.charAt(1) - '0' < 2){
                latestTime.setCharAt(0, '1');
            }else{
                latestTime.setCharAt(0, '0');
            }
            
        }
        if(latestTime.charAt(1) == '?'){
            if(latestTime.charAt(0) == '0'){
                latestTime.setCharAt(1,'9');
            }else{
                latestTime.setCharAt(1,'1');
            }
            
        }

        if(latestTime.charAt(3) == '?'){
            latestTime.setCharAt(3,'5');
        }
        if(latestTime.charAt(4) == '?'){
            latestTime.setCharAt(4,'9');
        }
        // for(int i=0;i<5;i++){
        //     char ch = s.charAt(i);
        //     if(ch == ':'){
        //         continue;
        //     }

        // }

        return latestTime.toString();
    }
}
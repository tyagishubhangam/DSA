class Solution {
    public String toGoatLatin(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        StringBuilder appender = new StringBuilder();
        for(int i=0;i<n;i++){
            StringBuilder tmp = new StringBuilder(arr[i]);
            if(!startWithVowel(tmp)){
                char ch = tmp.charAt(0);
                tmp.deleteCharAt(0);
                tmp.append(ch);
            }
            tmp.append("ma");
            appender.append('a');
            tmp.append(appender);
            arr[i] = tmp.toString();
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n-1;i++){
            ans.append(arr[i]);
            ans.append(" ");
        }
        ans.append(arr[n-1]);
        return ans.toString();
    }
    public boolean startWithVowel(StringBuilder s){
        if("aeiouAEIOU".indexOf(s.charAt(0))<0){
            return false;
        }

        return true;
    }
}
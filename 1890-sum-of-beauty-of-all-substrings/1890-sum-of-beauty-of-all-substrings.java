class Solution {
    public int beautySum(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            int arr[] = new int[26];
            for(int j=i;j<s.length();j++){
                arr[s.charAt(j) - 'a']++;
                result += getMaxFreq(arr) - getMinFreq(arr);
            }
        }
        return result;
        
    }
    public int getMinFreq(int arr[]){
        int res = Integer.MAX_VALUE;
        for(int i: arr){
            if(i != 0){
                res = Math.min(res, i);
            }
        }
        return res;
    }
    public int getMaxFreq(int arr[]){
        int res = 0;
        for(int i : arr){
            res = Math.max(res, i);
        }
        return res;
    }
}
class Solution {
    public int beautySum(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            int arr[] = new int[26];
            for(int j=i;j<s.length();j++){
                arr[s.charAt(j) - 'a']++;
                // result += getMaxFreq(arr) - getMinFreq(arr);
                result += getRes(arr);
            }
        }
        return result;
        
    }
    public int getRes(int arr[]){
        int resMin = Integer.MAX_VALUE;
        int resMax = 0;
        for(int i: arr){
            resMax = Math.max(resMax, i);
            if(i != 0){
                resMin = Math.min(resMin, i);
            }
        }
        return resMax - resMin;
    }
    // public int getMaxFreq(int arr[]){
    //     int res = 0;
    //     for(int i : arr){
    //         res = Math.max(res, i);
    //     }
    //     return res;
    // }
}
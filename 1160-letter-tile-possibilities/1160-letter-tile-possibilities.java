class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        return getAns(arr,0);
    }

    public static int getAns(char[] arr, int i){
        if(i == arr.length ){
            return 0;
        }
        
        int[] freq = new int[26];
        int ans = 0;
        for(int j=i;j<arr.length;j++){
            if(freq[arr[j]-'A']==0){
                swap(arr,i,j);
                ans += 1+getAns(arr,i+1);
                swap(arr,i,j);
            }
            freq[arr[j]-'A']++;
        }
        return ans;
    }

    public static void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0;i<mat.length;i++){
            hs.put(i,countOnes(mat[i]));
        }
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(hs.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());

        int[] result = new int[k];
        for (int i = 0; i < k && i < sortedEntries.size(); i++) {
            result[i] = (sortedEntries.get(i).getKey());
        }
        return result;
    }

    public static int countOnes(int[] arr){
        int l = 0;
        int r = arr.length - 1;
        while(l<=r){
            int mid = (l + r) / 2;
            if(arr[mid] == 1){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
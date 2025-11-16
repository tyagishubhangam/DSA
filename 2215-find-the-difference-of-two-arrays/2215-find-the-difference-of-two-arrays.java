class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i : nums1){
            hs.add(i);
        }
        for(int i : nums2){
            if(hs.contains(i)){
                hs.remove(i);
            }
        }
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int j : hs){
            ans.get(0).add(j);
        }
        hs.clear();
        for(int k : nums2){
            hs.add(k);
        }
        for(int l : nums1){
            if(hs.contains(l)){
                hs.remove(l);
            }
        }
        for(int d : hs){
            ans.get(1).add(d);
        }

        return ans;
    }
}
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<Pair> li = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            Pair tmp = new Pair(nums2[i], i);
            li.add(tmp);
        }
        int[] ans = new int[nums1.length];
        Collections.sort(li,new SortNums2());
        int l = 0;
        int r = nums2.length -1;
        for(int i=nums2.length - 1;i>=0;i--){
            if(nums1[r] > li.get(i).val){
                ans[li.get(i).idx] = nums1[r];
                r--;
            }else{
                ans[li.get(i).idx] = nums1[l];
                l++;
            }
        }
        return ans;
    }
}
class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
class SortNums2 implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p1.val - p2.val;
    }
}
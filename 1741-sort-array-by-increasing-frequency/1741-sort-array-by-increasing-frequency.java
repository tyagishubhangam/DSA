class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for(int i=0;i<nums.length;i++){
            freq[100+nums[i]] += 1;
        }
        Pair[] tmp = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            tmp[i] = new Pair(nums[i],freq[100+nums[i]]);
        }
        Arrays.sort(tmp, new SortByFreq());
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = tmp[i].val;
        }
        return res;
    }

    class Pair{
        int val; int freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }

    class SortByFreq implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            if(p1.freq != p2.freq){
                return p1.freq - p2.freq;
            }
            return p2.val - p1.val;
        }
    }
}
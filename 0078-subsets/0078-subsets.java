class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i< Math.pow(2,n);i++){
            List<Integer> tmp = new ArrayList<>();
            int[] bits = new int[n];
            getBits(i, bits);
            for(int pt = 0;pt<bits.length;pt++){
                if(bits[pt] == 1){
                    tmp.add(nums[pt]);
                }
            }
            li.add(tmp);
           
        }
        return li;
    }

    public static void getBits(int i,int[] bits){
        int end = 0;
        // int [] bits = new int[n/2];
        while(i != 0){
            bits[bits.length - end - 1] = i % 2;
            i = i/2;
            end++;
        }
        // return bits;
    }
    
}
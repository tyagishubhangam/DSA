class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        List<Integer> li = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(count1==0 && ele2!=nums[i]){
                count1=1;
                ele1 = nums[i];
            }else if(count2 == 0 && ele1!=nums[i]){
                count2 = 1;
                ele2 = nums[i];
            }else if(nums[i] == ele1){
                count1++;
            }else if(nums[i] == ele2){
                count2++;

            }else{
                count1--; count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == ele1){
                count1++;
            }if(nums[i] == ele2){
                count2++;
            }
        }
        if(count1>(n/3)){
            li.add(ele1);

        }if(count2>(n/3)){
            li.add(ele2);
        }
        Collections.sort(li);
        return li;
        
    }
}
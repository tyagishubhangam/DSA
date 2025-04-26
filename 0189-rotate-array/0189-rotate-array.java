class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        rotate(0,nums.length -k -1,nums);
        rotate(nums.length - k, nums.length - 1, nums);
        rotate(0,nums.length-1,nums);
        
    }

    public static void rotate(int i, int j, int[] arr){
        while(i<j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return;
    }
}
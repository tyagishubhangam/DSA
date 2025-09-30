class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i : nums){
            queue.offer(i);
        }
        while(queue.size() != 1){
            int len = queue.size();
            for(int i=1;i<len;i++){
                int x = queue.poll();
                int y = queue.peek();
                queue.offer((x+y)%10);
            }
            queue.poll();
        }

        return queue.poll();
    }
}
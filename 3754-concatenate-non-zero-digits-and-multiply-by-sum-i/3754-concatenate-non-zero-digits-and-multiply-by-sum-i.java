class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int num = n;
        StringBuilder ans = new StringBuilder();
        while(num != 0){
            int r = num % 10;
            sum += r;
            num = num / 10;
            if(r != 0){
                ans.append(r+"");
            }
        }
        if(ans.length() == 0){
            return 0l;
        }
        long val = Long.parseLong(ans.reverse().toString());
        return val * sum;
    }
}
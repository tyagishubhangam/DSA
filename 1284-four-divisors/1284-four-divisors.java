class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum += getDivSum(i);
        }
        return sum;
    }

    public static int getDivSum(int n){
        int sum = 0;
        int count = 0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                if(i * i == n){
                    count++;
                    sum += i;
                }else{
                    count += 2;
                    sum += i + n/i;
                }
            }
        }
        if(count == 4){
            return sum;
        }
            return 0;
        
    }
}
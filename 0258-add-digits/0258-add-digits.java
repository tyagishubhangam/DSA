class Solution {
    public int addDigits(int num) {
        if(num / 10 == 0){
            return num;
        }

        int digSum = 0;
        while(num != 0){
            digSum += num % 10;
            num = num / 10;
        }
        return addDigits(digSum);        


    }

}
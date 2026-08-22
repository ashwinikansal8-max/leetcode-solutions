class Solution {
    public int findSum(int num){
        int sum =0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }

    public int addDigits(int num) {
        int sum =0;
        while(num>=10){
            num = findSum(num);
        }
        return num;
    }
}
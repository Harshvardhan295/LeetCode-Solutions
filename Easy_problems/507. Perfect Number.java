class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum=0;
        for(int i=1;i<=num/2;i++){
            if (num%i==0){
                sum+=i;//sum gets bigger than i
            }
            if (sum<i){//check if any number does not divides num,then it returns sum directly.
                return false;
            }
        }
        return sum==num;
    }
}

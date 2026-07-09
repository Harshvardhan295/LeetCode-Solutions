// M1
class Solution {
    public int distinctPrimeFactors(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int factor = 2;

            while (a > 1) {
                while (a % factor == 0) {
                    set.add(factor);
                    a /= factor;
                }
                factor++;
            }
        }
        return set.size();
    }
}
// M2
class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> count=new HashSet<>();
        for(int num:nums){
            for(int j=2;j*j<=num;j++){
                while(num%j==0){
                    count.add(j);
                    num/=j;
                }
            }
            if(num!=1){ // number itself is prime..
                count.add(num);
            }
        }
        return count.size();
    }
}

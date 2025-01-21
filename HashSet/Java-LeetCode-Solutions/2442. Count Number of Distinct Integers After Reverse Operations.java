class Solution {
    public int reverse(int num) {
        int reverse = 0;  
        while (num != 0) {
            int digit = num % 10;  // Last digit 
            reverse = reverse * 10 + digit;  
            num = num / 10; 
        }
        return reverse;  
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele:nums){
            set.add(ele);
            set.add(reverse(ele));
        }
        return set.size();
    }
}

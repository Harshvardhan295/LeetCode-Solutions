class Solution {
    public int reverse(int x) {
        int num = x;
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;  // Last digit
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
        return reverse;
    }
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i< nums.length;i++){
            int ele=nums[i]-reverse(nums[i]);
            if(map.containsKey(ele)) {
                int freq=map.get(ele);
                count+=freq;
                count%=1000000007;
                map.put(ele, freq+1);
            }
            else map.put(ele,1);
        }
        return count;
    }
}

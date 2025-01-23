//Brute force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

// using hashmaps
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans={-1,-1};
        HashMap<Integer,Integer> m1=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int rem=target-nums[i];
            if(m1.containsKey(rem)){
                int j=m1.get(rem);//returns value, index here
                ans[0]=i;
                ans[1]=j;
                break;
            }
            else m1.put(nums[i],i);
        }
        return ans;
    }
}

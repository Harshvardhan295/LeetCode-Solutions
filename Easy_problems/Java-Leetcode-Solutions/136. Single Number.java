class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i] == nums[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag==true) {
                return nums[i];
            }
        }
        return -1;
        }
    }
//Bit Manipulation
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int e:nums){
            ans^=e;
        }
        return ans;
    }
}

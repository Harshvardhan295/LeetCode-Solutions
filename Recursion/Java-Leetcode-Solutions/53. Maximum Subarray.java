//Divide and Conquer
class Solution {
    public static int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int leftSum = maxSubArrayHelper(nums, left, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int crossSum = maxCrossingSum(nums, left, mid, right);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftMaxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }

        int rightMaxSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, sum);
        }

        return leftMaxSum + rightMaxSum;
    }
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums,0,nums.length-1);
    }
}

//-------------------Optimised code----------------
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0;
        int maxsum=nums[0];
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>maxsum){
                maxsum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxsum;
    }
}
//-------------------Brute Force----------------
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxsum = Integer.MIN_VALUE; 
        
        for (int i = 0; i < n; i++) {
            int sum = 0; 
            
            for (int j = i; j < n; j++) {
                sum += nums[j]; 
                if (sum > maxsum) {
                    maxsum = sum;
                }
            }
        }
        
        return maxsum;
    }
}

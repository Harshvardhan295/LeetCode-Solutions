//Brute Force
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length, count=0;
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                product*=nums[j];
                if(product<k) count++;
                else break;
            }
        }
        return count;
    }
}
// Slidign Window
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; 

        int count = 0, product = 1;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            // Shrink the window until the product is less than k
            while (product >= k && j <= i) {
                product /= nums[j++];
            }

            // Count all valid subarrays that end at `right`
            count += (i - j + 1);
        }

        return count;
    }
}

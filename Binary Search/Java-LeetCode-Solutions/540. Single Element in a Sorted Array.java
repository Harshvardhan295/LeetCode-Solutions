class Solution {
    int helper(int[] arr) {
        int l = 0, h = arr.length - 1;
        int ans = -1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1])
                return arr[mid];
            if (arr[l] != arr[l + 1])
                return arr[l];
            if (arr[h] != arr[h - 1])
                return arr[h];
            l += 2;
            h -= 2;
        }
        return ans;
    }

    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int ans = helper(nums);
        if (ans != -1)
            return ans;
        else
            return helper(nums);
    }
}

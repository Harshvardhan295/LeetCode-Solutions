class Solution{
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int i = 0, n = nums.length, res = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int a = nums[j];
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
            if (cnt.get(a) == 1)
                k -= a;
            while (k <= 0) {
                res = Math.min(res, j - i + 1);
                cnt.put(nums[i], cnt.get(nums[i]) - 1);
                if (cnt.get(nums[i]) == 0)
                    k += nums[i];
                i++;
            }
        }
        System.out.println(k);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

class Solution {
    public String helper(String[] nums, HashSet<String> set, String ans, int i) {
        int n = nums[0].length();
        System.out.println(ans);
        if(i == n){
            if(!set.contains(ans)) return ans;
            return "";
        }

        String left = helper(nums, set, ans + "0", i + 1);
        if(!left.equals("")) return left;

        String right = helper(nums, set, ans + "1", i + 1);
        if(!right.equals("")) return right;

        return "";
    }

    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String a : nums){
            set.add(a);
        }

        return helper(nums, set, "", 0);
    }
}

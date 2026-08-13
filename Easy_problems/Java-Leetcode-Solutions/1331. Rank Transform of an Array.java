class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int[] nums=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i]=arr[i];
        }
        Arrays.sort(nums);
        int a=1;
        for(int i=0;i<nums.length;i++){
            if(!mp.containsKey(nums[i])) {
                mp.put(nums[i],a);
                a++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=mp.get(arr[i]);
        }
        return arr;
    }
}

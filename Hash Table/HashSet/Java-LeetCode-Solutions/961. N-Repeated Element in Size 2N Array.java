//HashSet
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums)
        {
            if(!s.add(i))
              return i;
        }
        return nums[nums.length-1];
    }
}
//HashMap
class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int maxCnt=Integer.MIN_VALUE;
        int maxNum=-1;
        for(int key:mp.keySet()){
            if(mp.get(key)>maxCnt) {
                maxCnt=mp.get(key);
                maxNum=key;
            }
        }
        return maxNum;
    }
}

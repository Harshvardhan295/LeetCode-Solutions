class Solution {
    public int maxDigitRange(int[] nums) {

        int sum=0;
        List<Integer> ans=new ArrayList<>();
        int maxDigRange=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            while(n!=0){
                int d=n%10;
                min=Math.min(min,d);
                max=Math.max(max,d);
                n/=10;
            }
            ans.add(max-min);
            maxDigRange=Math.max(ans.get(ans.size()-1),maxDigRange);
        }
        
        for(int i=0;i<ans.size();i++){
            if(ans.get(i)==maxDigRange) sum+=nums[i];
        }
        return sum;
    }
}

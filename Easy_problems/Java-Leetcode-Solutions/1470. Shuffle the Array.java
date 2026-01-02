class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[2*n];
        int j=0,k=1;
        for(int i=0;i<2*n;i+=2){
            ans[i]=nums[j];
            ans[k]=nums[j+n];
            j++;
            k+=2;
        }
        return ans;
    }
}

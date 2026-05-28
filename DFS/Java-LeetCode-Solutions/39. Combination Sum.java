class Solution {
    List<List<Integer>> ans;
    public void helper(int[] c, int t,int sum,List<Integer> arr,int idx){
        if(sum==t){
            ans.add(new ArrayList<>(arr));
        }
        if(sum>t) return;
        for(int i=idx;i<c.length;i++){
            sum+=c[i];
            arr.add(c[i]);
            helper(c,t,sum,arr,i);
            sum-=c[i];
            arr.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] c, int t) {
        ans=new ArrayList<>();
        helper(c,t,0,new ArrayList<>(),0);
        return ans;
    }
}

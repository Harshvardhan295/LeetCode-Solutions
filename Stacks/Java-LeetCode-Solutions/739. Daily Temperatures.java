class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        Stack<Integer> sc=new Stack<>();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            while(!sc.isEmpty() && temp[sc.peek()]<temp[i]){
                int idx=sc.pop();
                ans[idx]=i-idx;
            }
            sc.push(i);
        }
        return ans;
    }
}

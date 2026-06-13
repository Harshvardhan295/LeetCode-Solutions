class Solution {
    public int finalValueAfterOperations(String[] op) {
        int ans=0;
        for(int i=0;i<op.length;i++){
            if(op[i].equals("++X") || op[i].equals("X++")) ans++;
            else ans--;
        }
        return ans;
    }
}

class Solution {
    public boolean isvalid(int x,int k,String s) {
        int set=0,cost=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='1'){
                set++;
                cost+=i;
                if(set>1 || cost>k){
                    return false;
                }
            }
            else set=0;
            
        }

        return true;
    }

    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            String binaryStr = Integer.toBinaryString(i);
            String res = String.format("%" + n + "s", binaryStr).replace(' ', '0');
            if (isvalid(i,k,res)) {
                
                ans.add(res);
            }
        }
        return ans;
    }
}

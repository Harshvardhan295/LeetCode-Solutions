class Solution {
    public boolean uniformArray(int[] a) {
        int n=a.length;
        boolean hasEven=false;
        boolean hasOdd=false;
        int minOdd=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(a[i]%2==0) hasEven=true;
            else hasOdd=true;
            if(a[i]%2!=0 && a[i]<minOdd){
                minOdd=a[i];
                idx=i;
            }
        }
        if(hasEven && hasOdd){
            for(int i=0;i<n;i++){
                if(a[i]%2==0 && a[i]-minOdd <1){
                    return false;
                }
            }
        }
        return true;
    }
}

//Sliding Window
class Solution {
    public int maxSatisfied(int[] c, int[] g, int k) {
        int n=c.length;
        int i=0,j=k-1;
        int unsatisfied=0;
        int a=i,b=j, maxUnsatisfied=0;
        for(int x=i;x<=j;x++){
            if(g[x]==1) unsatisfied+=c[x];
        }
        while(j<n){
            if(unsatisfied>maxUnsatisfied){
                maxUnsatisfied=unsatisfied;
                a=i; b=j;
            }
            if(j==n-1) break;
            if(g[i]==1) unsatisfied-=c[i];
            i++;
            j++;
            if(g[j]==1) unsatisfied+=c[j];
        }
        int satisfied=0;
        for(int x=a;x<=b;x++){
            g[x]=0;
        }
        for(int x=0;x<n;x++){
            if(g[x]==0) satisfied+=c[x];
        }
        return satisfied;
    }
}

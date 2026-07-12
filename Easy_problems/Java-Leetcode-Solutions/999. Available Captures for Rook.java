class Solution {
    public int numRookCaptures(char[][] arr) {
        int ans=0; 
        boolean gotRook=false;;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(arr[i][j]=='R'){
                    gotRook=true;
                    int a=i,b=j;
                    while(a>=0){
                        if(arr[a][b]=='B') break;
                        if(arr[a][b]=='p') {
                            ans++;
                            break;
                        }
                        a--;
                    }
                    a=i;b=j;
                    while(a<8){
                        if(arr[a][b]=='B') break;
                        if(arr[a][b]=='p') {
                            ans++;
                            break;
                        }
                        a++;
                    }
                    a=i;b=j;
                    while(b>=0){
                        if(arr[a][b]=='B') break;
                        if(arr[a][b]=='p') {
                            ans++;
                            break;
                        }
                        b--;
                    }
                    a=i;b=j;
                    while(b<8){
                        if(arr[a][b]=='B') break;
                        if(arr[a][b]=='p') {
                            ans++;
                            break;
                        }
                        b++;
                    }
                    break;
                }
            }
            if(gotRook) break;
        }
        return ans;
    }
}

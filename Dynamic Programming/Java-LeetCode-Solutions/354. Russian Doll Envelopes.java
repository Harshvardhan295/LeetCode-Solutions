class Solution {
    public class Envelop implements Comparable<Envelop> {
        int w;
        int h;

        Envelop(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public int compareTo(Envelop e) {
            if (this.w == e.w)
                return e.h - this.h;  // sort descending by height if width is same
            return this.w - e.w;      // sort ascending by width
        }
    }

    public int maxEnvelopes(int[][] env) {
        int n = env.length;
        Envelop[] arr = new Envelop[n];
        for (int i = 0; i < n; i++) {
            int w = env[i][0];
            int h = env[i][1];
            arr[i] = new Envelop(w, h);
        }

        Arrays.sort(arr);

        int[] dp=new int[n];
        int max=0;
        //LIS
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(arr[j].h<arr[i].h) dp[i]=Math.max(dp[i],dp[j]);
            }
            dp[i]+=1;
            max=Math.max(dp[i],max);
        }
        return max;
    }
}


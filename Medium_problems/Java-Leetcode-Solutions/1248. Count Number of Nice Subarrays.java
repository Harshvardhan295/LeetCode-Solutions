//Sliding Windows
class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int n = arr.length, i = 0, j = 0, a = 0, b = 0;
        int count = 0, nOdds = 0;
        while (i < n && arr[i] % 2 == 0) i++;// move i to 1st one
        while (j < n && nOdds < k) {
            if (arr[j++] % 2 != 0)
                nOdds++;
        }
        if(nOdds<k) return 0; //if there are less than k odd numbers return 0;
        j--;

        //positioning j
        b = j + 1;
        while (b < n && arr[b] % 2 == 0) b++;
        b--;
        
        while(b<n){//sliding window
            int len1 = i - a + 1;
            int len2 = b - j + 1;
            count += len1 * len2;
            a=i+1;
            // positioning i
            i++;
            while(i<n && arr[i]%2==0) i++;
            //positioning j
            j=b+1;
            b=j+1;
            while (b < n && arr[b] % 2 == 0) b++;
        b--;
        }
        return count;
    }
}

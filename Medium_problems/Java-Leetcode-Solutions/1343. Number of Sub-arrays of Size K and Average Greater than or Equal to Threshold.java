//Sliding Window
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int Sum=0,average=0, count=0;
        for(int i=0;i<k;i++){
            Sum+=arr[i];
        }
        average=Sum/k;
        if(average>=threshold) count++;

        for(int i=k;i<n;i++){
            Sum+=arr[i]-arr[i-k];
            average=Sum/k;
            if(average>=threshold) count++;
        }
        return count;
    }
}
//Brute Force
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length,count=0;
        for(int i=0;i<n-k+1;i++){
            int sum=0,average=0;
            for(int j=i;j<i+k;j++){
                sum+=arr[j];
            }
            average=sum/k;
            if(average>=threshold) count++;
        }
        return count;
    }
}

class Solution {
    public int candy(int[] arr) {
        int n=arr.length;
        int[] numCandies=new int[n];
        for(int i=0;i<n;i++) numCandies[i]=1;//give 1 candie to each 
        //Left to right pass
        for(int i=1;i<n;i++) if(arr[i]>arr[i-1]) numCandies[i] = numCandies[i-1] + 1;
        //Right to left pass
        for (int i= n-2;i>=0;i--) {
            if (arr[i]>arr[i+1]) {
                numCandies[i] =Math.max(numCandies[i],numCandies[i+1]+1);
            }
        }
        int sum=0;
        for(int ele:numCandies) sum+=ele;
        return sum;
    }
}

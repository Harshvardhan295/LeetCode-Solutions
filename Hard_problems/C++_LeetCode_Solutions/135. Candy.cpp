class Solution {
public:
    int candy(vector<int>& arr) {
        int n=arr.size();
        vector<int> numCandies(n, 1);//give 1 candie to each 

        //Left to right pass
        for(int i=1;i<n;i++) if(arr[i]>arr[i-1]) numCandies[i] = numCandies[i-1] + 1;
        //Right to left pass
        for (int i= n-2;i>=0;i--) {
            if (arr[i]>arr[i+1]) {
                numCandies[i] =max(numCandies[i],numCandies[i+1]+1);
            }
        }
        int sum=0;
        for(int ele:numCandies) sum+=ele;
        return sum;
    }
};

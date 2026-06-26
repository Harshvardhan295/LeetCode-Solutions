class Solution {
    public boolean containsDuplicate(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int x=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]==x) return true;
            else x=arr[i];
        }
    return false;
    }
}

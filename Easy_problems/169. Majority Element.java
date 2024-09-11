class Solution {
    public int majorityElement(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        return a[n/2];//returning the middle element
    }
}

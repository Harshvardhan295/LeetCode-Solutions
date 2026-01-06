class Solution {
    public String reversePrefix(String s, int k) {
        char[] arr = s.toCharArray();
        int start = 0, end = k - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }
}

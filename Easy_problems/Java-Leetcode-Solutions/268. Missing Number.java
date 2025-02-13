//Optimal
class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2; 
        int actualSum = 0;
        
        for (int num : arr) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
}
//Brute force
class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }
}
        

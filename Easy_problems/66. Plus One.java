//Optimised Code
class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i] += 1;
                return arr;
            }
            
            arr[i] = 0;
        }
        
        int[] newArr = new int[n + 1];
        newArr[0] = 1; 
        return newArr;
    }
}
//Brute Force
class Solution {
    public int[] plusOne(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
        }
        
        num += 1;
        
        String str = Integer.toString(num);
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i) - '0';
        }
        
        return result;
    }
}

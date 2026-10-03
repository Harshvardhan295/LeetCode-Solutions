//_____________Method 1_____________________
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int num = x;
        
        while(num!=0){
            sum += num%10;
            num/=10;
        }
        if(x%sum == 0)  return sum;
        return -1;
    }
}
//_____________Method 2_____________________
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {

        String numberStr = Integer.toString(x);
        int sum = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            sum += Character.getNumericValue(numberStr.charAt(i));
        }
        if (x % sum == 0)
            return sum;
        else
            return -1;
    }
}

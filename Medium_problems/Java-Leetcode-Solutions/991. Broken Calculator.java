// Recursive
class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue >= target) return startValue - target;
        if(target % 2 == 0){
            return 1 + brokenCalc(startValue, target / 2);
        }
        return 1 + brokenCalc(startValue, target + 1);
    }
}

// Iterative
class Solution {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while(target > startValue){
            if(target % 2 == 0){
                target /= 2;
            }
            else{
                target++;
            }
            ans++;
        }
        return ans + (startValue - target);
    }
}

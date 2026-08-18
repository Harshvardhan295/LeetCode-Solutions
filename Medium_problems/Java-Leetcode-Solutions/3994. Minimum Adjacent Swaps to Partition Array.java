class Solution {
    int MOD = (int)(1e09+7);
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long count1 = 0;// sab ele jo a aur b ke beech main hai unhe milakar
        long count2 = 0; // sab ele jo b se bde hai..
        long res = 0;
        for(int num : nums) {
            // aisa ele mila jo a se chota hai... toh ab tkk jitne bi aise ele mile jo a aur b ke beech aate hai aur jo b se bde hai.. unko add kr do.. kyuki unko swap krke hi unko sahi position tkk la payenge
            if(num < a) {
                res += (count1+count2);
            }
            // agr ele a aur b ke beech main aata hai, toh jitne elements abi tk aise the jo b se bde the (cnt2) unko res main add krdo, kyuki tumhe vo unn ele se phle mila jo a se bde aur b se chote hai (basically second wle group se phle mil gya), toh utne swaps toh lgenge sahi position lane ko.. 
            else if(num >= a && num <= b) {
                res += count2;
                count1++;
            }
            //agr vo b se bda hai , toh cnt2 bda do
            else { 
                count2++;
            }
        }
        return (int)(res%MOD);
    }
}

//Smart Solution
class Solution {
    //TC=O(1)
    public int xorUpto(int x) {
        if (x % 4 == 0) return x;
        if (x % 4 == 1) return 1;
        if (x % 4 == 2) return x + 1;
        return 0; //x % 4 == 3
    }
//tricky solution
    public int xorOperation(int n, int start) {
        int s = start >> 1;
        // XOR of range [s, s+n-1]
        int xor = xorUpto(s - 1) ^ xorUpto(s + n - 1);
        // add back last bit if start is odd
        return (xor << 1) | (start & 1 & n);
    }
}

//Simple Solution
class Solution {
    public int xorOperation(int n, int start) {
        int ans=0;
        for(int i=0;i<n;i++){
            ans=ans^start;
            start+=2;
        }
        return ans;
    }
}

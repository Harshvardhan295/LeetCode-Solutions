//Hashmap
class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int a:nums){
            if(!mp.containsKey(a)) mp.put(a,1);
            else mp.put(a,2);
        }
        int[] ans=new int[2];
        int i=0;
        for(int k: mp.keySet()){
            if(mp.get(k)==1) ans[i++]=k;
            if(i>1) break;
        }
        return ans;
    }
}
//Sorting
class Solution {
    public int[] singleNumber(int[] arr) {
        Arrays.sort(arr);
        int[] ans=new int[2];
        int i=0,idx=0;
        while(i<arr.length-1){
            if(arr[i]==arr[i+1]) i+=2;
            else ans[idx++]=arr[i++];
            if(idx>1) break;
        }
        if(idx==1) ans[idx]=arr[arr.length-1];
        return ans;
    }
}

//Bit manipulation
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        for (int num : nums) {
            xor ^= num;
        }
        // either this
        int rightbitoff = (xor & (xor - 1));
        int mask = rightbitoff ^ xor;
        
        // or this
        // int mask = xor & (-xor);
        
        int b1=0,b2=0;
        for (int num : nums) {
            if ((num & mask) == 0) b1 ^= num;
            else b2 ^= num;
        }
        
        return new int[]{b1, b2};
    }
}

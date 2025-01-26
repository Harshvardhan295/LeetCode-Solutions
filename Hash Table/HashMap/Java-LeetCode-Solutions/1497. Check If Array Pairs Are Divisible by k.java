class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        //add mod value for each element in map
        for (int i = 0; i < n; i++) {
            // int ele = arr[i] % k;
            // if(ele<0) ele=ele+k;  OR
            int ele=((arr[i]%k)+k)%k;
            if (map.containsKey(ele)) {
                int freq = map.get(ele);
                map.put(ele, freq + 1);
            } else
                map.put(ele, 1);
        }
        //if no. of 0,s are odd then return false
        if(map.containsKey(0)){
            if(map.get(0)%2!=0) return false;
            map.remove(0);//remove 0 from map
        }
        if(k%2==0 && map.containsKey(k/2)){
            if(map.get(k/2)%2!=0) return false;
            map.remove(k/2);
        }
        for (int key : map.keySet()) {
            int rem = k - key;
            if (!map.containsKey(rem))
                return false;
            int keyfreq = map.get(key);
            int remfreq = map.get(rem);
            if (keyfreq != remfreq)
                return false;
        }
        return true;
    }
}

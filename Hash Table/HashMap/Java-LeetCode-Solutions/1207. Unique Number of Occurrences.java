class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int freq=map.get(arr[i]);
                map.remove(arr[i]);
                map.put(arr[i], freq + 1);
            }
            else map.put(arr[i],1);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int val:map.keySet()){
             // get gives value of that key
            set.add(map.get(val));
        }
        return set.size()==map.size();
    }
}

//Sliding Windows
class Solution {
    public int totalFruit(int[] arr) {
        int n=arr.length;
        int i=0,j=0;
        int maxFruits=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>2){
                int freq=map.get(arr[i]);
                if(freq==1) map.remove(arr[i]);
                else{
                    map.put(arr[i],freq-1);
                }
                i++;
            }
            int len=j-i+1; //if (map.size()<=2)
            maxFruits=Math.max(maxFruits,len);
            j++;
        }
        return maxFruits;
    }
}

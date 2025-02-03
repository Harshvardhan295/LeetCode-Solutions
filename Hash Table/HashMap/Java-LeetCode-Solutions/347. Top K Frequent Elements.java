class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int freq;
        Pair(int x,int freq){
            this.x=x;
            this.freq=freq;
        }
        public int compareTo(Pair p){
            return this.freq-p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        for(int i=0;i< nums.length;i++) {
            int ele = nums[i];
            map.put( ele, map.getOrDefault(ele, 0) + 1);
        }
        //Min Heap
        for(int ele:map.keySet()){
            int freq=map.get(ele);
            pq.add(new Pair(ele,freq));
            if(pq.size()>k) pq.remove();
        }

        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            Pair pair=pq.remove();
            ans[i]=pair.x;
        }
        return ans;
    }
}

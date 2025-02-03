class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int freq;
        Pair(int x,int freq){
            this.x=x;
            this.freq=freq;
        }
        public int compareTo(Pair p){
            if (this.freq == p.freq) {
                return p.x - this.x; //when frequency is the same,sort by value in descending order 
            }
            return this.freq-p.freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //Min Heap
        for(int ele:map.keySet()){
            int freq=map.get(ele);
            pq.add(new Pair(ele,freq));
        }
        int i = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int count = pair.freq;
            while (count-- > 0) {
                nums[i++] = pair.x;
            }
        }
        return nums;
    }
}

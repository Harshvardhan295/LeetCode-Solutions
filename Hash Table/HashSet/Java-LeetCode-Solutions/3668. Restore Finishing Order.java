class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> s = new HashSet<>();
        for (int a : friends) s.add(a);
        int idx=0;
        for(int i=0;i<order.length;i++){
            if(s.contains(order[i])) friends[idx++]=order[i];
        }
        return friends;
    }
}

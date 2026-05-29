class EventManager {

    // eventId -> current priority
    private Map<Integer, Integer> mp;

    // max heap: {priority, -eventId}
    private PriorityQueue<int[]> pq;

    public EventManager(int[][] events) {
        mp = new HashMap<>();

        pq = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // max priority first
            return b[0] - a[0]; // max (-id) first
        });

        for (int[] e : events) {
            int id = e[0];
            int pr = e[1];
            mp.put(id, pr);
            pq.offer(new int[]{-id, pr});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        mp.put(eventId, newPriority);
        pq.offer(new int[]{-eventId, newPriority}); // push new entry
    }
    
    public int pollHighest() {
        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            int pr = top[1];
            int negId = top[0];
            int id = -negId;

            // valid entry check
            if (mp.containsKey(id) && mp.get(id) == pr) {
                pq.poll();
                mp.remove(id); // mark as removed
                return id;
            }

            pq.poll(); // discard wrong entry and we move to smallest events
        }

        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */

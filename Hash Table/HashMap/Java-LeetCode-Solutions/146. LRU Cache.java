class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        //Move accessed node to front.
        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {
        //If key exists → update value & move to front.
        //If cache is full → remove node before tail (LRU).
        //Insert new node after head.
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);

            remove(oldNode);
        }

        Node newNode = new Node(key, value);

        insert(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

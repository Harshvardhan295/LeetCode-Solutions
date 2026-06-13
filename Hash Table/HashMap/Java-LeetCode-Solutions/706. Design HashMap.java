// Method 1
class MyHashMap {
    int[] data;
    public MyHashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }
    public void put(int key, int val) {
        data[key] = val;
    }
    public int get(int key) {
        return data[key];
    }
    public void remove(int key) {
        data[key] = -1;
    }
}

// Method 2
class Pair {
    int key;
    int val;
    Pair next;

    Pair(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

class MyHashMap {
    private int hash(int key) {
        return key % 1000;
    }

    private Pair[] map;

    public MyHashMap() {
        map = new Pair[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new Pair(-1, -1);
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Pair cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }

        cur.next = new Pair(key, value);
    }

    public int get(int key) {
        int hash = hash(key);
        Pair cur = map[hash].next;

        while (cur != null) {
            if (cur.key == key)
                return cur.val;
            cur = cur.next;
        }

        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Pair cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

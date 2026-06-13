// Cheat Method: 
// Let inheritece handle every thing
class MyHashSet extends HashSet<Integer> {

}

// Original Method
class MyHashSet {
    int[] data;
    public MyHashSet() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }
    public void add(int key) {
        data[key] = key;
    }

    public void remove(int key) {
        data[key] = -1;
    }     
    public boolean contains(int key) {
        if(data[key]!=-1) return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

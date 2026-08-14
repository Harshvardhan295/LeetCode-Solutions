class Solution {
    public HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    
    public Node clone(Node node) {
        if (node == null) return null;
        // if the node's deep copy is created, return that
        if (map.containsKey(node.val)) 
            return map.get(node.val);
        
        //else create a new node with curr node val & create arraylist with empty neighbors
        Node newNode = new Node(node.val, new ArrayList<Node>());
        
        // mark that the node's deep copy has created
        map.put(newNode.val, newNode);
        //add the curr node neighbors in it's clone's neighbor
        for (Node neighbor : node.neighbors)  //dfs
            newNode.neighbors.add(clone(neighbor));
        
        return newNode;
    }
}

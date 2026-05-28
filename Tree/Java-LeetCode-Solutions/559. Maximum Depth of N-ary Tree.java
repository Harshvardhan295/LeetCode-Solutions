/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    int maxD = 0;

    public void levels(Node root, int depth) {
        if (root == null) return;

        maxD = Math.max(maxD, depth); 
        for (int i = 0; i < root.children.size(); i++) {
            levels(root.children.get(i), depth + 1); // explore that node
        }
    }

    public int maxDepth(Node root) {
        levels(root, 1); 
        return maxD;
    }
}

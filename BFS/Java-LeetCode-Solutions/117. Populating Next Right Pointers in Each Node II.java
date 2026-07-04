//BFS solution
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            
            for (int i = 0; i < levelSize; i++) {
                //current refers to the exact same object memory location as root
                Node current = q.remove();
                
                // If it's NOT the last node in this level, point next to the queue's front node
                if (i < levelSize - 1) {
                    current.next = q.peek(); 
                } else {// Last node of the level points to null
                    current.next = null; 
                }
                
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
        }
        return root;
    }
}
    

//Linked List Solution
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
       if(root == null) return root;
       Node current = root;
       while(current != null){
            Node dummy = new Node(0);
            Node tail = dummy;

            while(current != null){
                if(current.left != null){
                    tail.next = current.left;
                    tail = tail.next;
                }
                if(current.right != null){
                    tail.next = current.right;
                    tail = tail.next;
                }
                System.out.println("before:"+current.val);
                current = current.next;
                System.out.println("after:"+current);
            }
                System.out.println("dummy:"+dummy.val);

            current = dummy.next;
       }
       return root;
    }
   
}

//Epic solution, logic: smart linking of nodes
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node leftMost = root;

        while (leftMost.left != null) {
            Node head = leftMost;

            while (head != null) {
                // Connect left child to right child
                head.left.next = head.right;

                // Connect right child to next node's left child
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }
}

// Decent Solution
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
    

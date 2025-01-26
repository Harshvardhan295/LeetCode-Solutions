class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node head2 = new Node(head.val);
        Node t2 = head2;
        Node t1 = head.next;
        while (t1 != null) {// creating deep copy
            Node dup = new Node(t1.val);
            t2.next = dup;
            t1 = t1.next;
            t2 = t2.next;
        }
        HashMap<Node, Node> map = new HashMap<>();
        t2 = head2;
        t1 = head;
        while (t1 != null) {
            map.put(t1, t2);
            t1 = t1.next;
            t2 = t2.next;
        }
        for (Node original : map.keySet()) {
            Node duplicate = map.get(original);
            if (original.random != null)
                duplicate.random = map.get(original.random);
        }
        return head2;
    }
}

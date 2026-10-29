/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;

        Map<Node, Node> clones = new HashMap<>();

        Node itr = head;
        while(itr != null) {
            Node clone = new Node(itr.val);
            clones.put(itr, clone);
            itr = itr.next;
        }

        itr = head;
        while(itr != null) {
            Node clone = clones.get(itr);
            clone.next = clones.get(itr.next);
            clone.random = clones.get(itr.random);
            itr = itr.next;
        }

        return clones.get(head);
    }
}

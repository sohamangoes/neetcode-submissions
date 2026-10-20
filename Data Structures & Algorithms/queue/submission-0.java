class Deque {

    int length;
    Node begin;
    Node end;

    public Deque() {
        begin = null;
        end = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void append(int value) {
       
       Node newNode = new Node(value);
       
       if(length == 0) {
        begin = newNode;
        end = newNode;
        length++;
        return;
       }

       newNode.prev = end;
       end.next = newNode;
       end = newNode;
       length++;
    }

    public void appendleft(int value) {

        Node newNode = new Node(value);
        
        if(length == 0) {
            begin = newNode;
            end = newNode;
            length ++;
            return;
        }
        
        newNode.next = begin;
        begin.prev = newNode;
        begin = newNode;
        length ++;
    }

    public int pop() {

        if(length == 0) return -1;
        
        if(length == 1) {
            int val = begin.val;
            begin = null;
            end = null;
            length = 0;
            return val;
        }

        int val = end.val;
        end.prev.next = null;
        end = end.prev;
        length--;
        return val;
    }

    public int popleft() {

        if(length == 0) return -1;

        if(length == 1) {
            int val = begin.val;
            begin = null;
            end = null;
            length = 0;
            return val;
        }
        
        int val = begin.val;
        begin.next.prev = null;
        begin = begin.next;
        length--;
        return val;
    }

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
        }
    }
}

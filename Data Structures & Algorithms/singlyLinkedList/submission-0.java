class LinkedList {

    private Node head = null;
    private int length = 0;

    public LinkedList() {

    }

    public int get(int index) {

        if(index > length - 1) return -1;
        
        Node it = head;
        int i = 0;
        while(it != null) {
            if(i == index) {
                return it.val;
            }
            if(i > index) {
                return -1;
            }
            it = it.next;
            i++;
        }
        
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        
        if(head == null) {
            head = newNode;
            length++;
            return;
        }
        
        newNode.next = head;
        head = newNode;
        
        length++;
    }

    public void insertTail(int val) {
        
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            length++;
            return;
        }
        
        Node it = head;
        while(it.next != null) {
            it = it.next;
        }
        it.next = newNode;

        length++;
    }

    public boolean remove(int index) {
        if(index > length - 1) return false;

        if(index == 0) {
            head = head.next;
            length--;
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        int i = 1;
        while(i <= index) {
            
            if(i == index) {
                prev.next = curr.next;
                length--;
                return true;
            }

            i++;
            prev = prev.next;
            curr = curr.next;
        }

        return false;

    }

    public ArrayList<Integer> getValues() {

        ArrayList<Integer> values = new ArrayList();

        if(head == null) {
            return values;
        }

        Node it = head;
        while(it != null) {
            values.add(it.val);
            it = it.next;
        }

        return values;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
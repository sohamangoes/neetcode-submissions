class LRUCache {
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> nodes;
    int length;
    int capacity;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        length = 0;
        this.capacity = capacity;
        this.nodes = new HashMap<>();
    }
    
    public int get(int key) {
        
        return findByKey(key)
            .map(
                found -> {
                    moveToHead(found);
                    return found.value;
                }
            ).orElse(-1);
    }
    
    public void put(int key, int value) {
        findByKey(key).ifPresentOrElse(
            found -> {
                found.value = value;
                moveToHead(found);
            },
            ()-> {

                if(isFull()) {
                    evict();
                }

                ListNode newNode = new ListNode(key, value);
                pushToHead(newNode);
                nodes.put(key, newNode);
            }
        );
    }

    private Optional<ListNode> findByKey(int key) {
        return Optional.ofNullable(nodes.get(key));
    }

    private void evict() {
        popFromTail().ifPresent(popped -> nodes.remove(popped.key));
    }

    private void pushToHead(ListNode node) {
        
        if(isEmpty()) {
            head = node;
            tail = node;
            length++;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
        length++;
    }

    private Optional<ListNode> popFromTail() {
        
        if(isEmpty()) return Optional.empty();

        if(length == 1) {
            ListNode popped = tail;
            length --;
            tail = null;
            head = null;
            return Optional.of(popped);
        }

        ListNode popped = tail;
        length --;
        tail = popped.prev;
        tail.next = null;
        return Optional.of(popped);
    }

    private void moveToHead(ListNode node) {
        
        if(isEmpty()) return;
        if(isHead(node)) return;

        if(isTail(node) && length == 1) {
            return;
        }

        if(isTail(node)) {

            tail = node.prev;
            tail.next = null;

            head.prev = node;
            node.next = head;
            node.prev = null;
            head = node;

            return;
        }

        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;

        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }

    private boolean isHead(ListNode node) {
        return node.prev == null;
    }

    private boolean isTail(ListNode node) {
        return node.next == null;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private boolean isFull() {
        return length == capacity;
    }



    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

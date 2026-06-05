class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    public int capacity;
    public Node dummyHead;
    public Node dummyTail;
    public HashMap<Integer, Node> mpp;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        mpp = new HashMap<>();

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    private void remove(Node node) {
        Node back = node.prev;
        Node front = node.next;

        back.next = front;
        front.prev = back;
    }
    
    private void addToFront(Node node) {
        Node prevHead = dummyHead.next;

        dummyHead.next = node;
        node.prev = dummyHead;

        prevHead.prev = node;
        node.next = prevHead;
    }

    public int get(int key) {
        if(mpp.containsKey(key)) {
            Node node = mpp.get(key);
            int value = node.value;
            
            remove(node);
            addToFront(node);
            
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(!mpp.containsKey(key)) {
            Node node = new Node(key, value);
            if(mpp.size() < capacity) {
                addToFront(node);
                mpp.put(key, node);
            }
            else {
                Node lastNode = dummyTail.prev;
                remove(lastNode);
                addToFront(node);

                mpp.remove(lastNode.key);
                mpp.put(key, node);   
            }
        }
        else {
            Node node = mpp.get(key);
            node.value = value;

            remove(node);
            addToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
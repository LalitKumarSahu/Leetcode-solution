import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    // Constructor
    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy nodes
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Get value
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move accessed node to front
        removeNode(node);
        addToFront(node);

        return node.value;
    }

    // Put key-value
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            removeNode(oldNode);
            map.remove(key);
        }

        Node newNode = new Node(key, value);
        addToFront(newNode);
        map.put(key, newNode);

        // If capacity exceeded
        if (map.size() > capacity) {
            Node lru = tail.prev;   // Least Recently Used
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    // Remove node from DLL
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node just after head
    public void addToFront(Node node) {
        Node first = head.next;

        head.next = node;
        node.prev = head;

        node.next = first;
        first.prev = node;
    }
}

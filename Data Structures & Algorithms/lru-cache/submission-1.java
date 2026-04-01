class LRUCache {

    class Node {
        int k, v;
        Node prev, next;
        public Node(int key, int value) {
            this.k = key;
            this.v = value;
        }
    }
    Map<Integer, Node> map;
    Node head, tail; 
    int capacity ; 
    int size = 0; 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {    
        if(map.containsKey(key)) {
            Node found = map.get(key);
            if(!found.equals(tail.prev)){
                Node foundprev = found.prev;
                Node foundnext = found.next;
                foundprev.next = foundnext;
                foundnext.prev = foundprev;

                Node actualtail = tail.prev ; 
                actualtail.next = found;
                found.prev = actualtail;
                found.next = tail;
                tail.prev = found;
            }
            return found.v;
        }   
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node found = map.get(key);
            found.v = value;
            if(!found.equals(tail.prev)){
                Node foundprev = found.prev;
                Node foundnext = found.next;
                foundprev.next = foundnext;
                foundnext.prev = foundprev;

                Node actualtail = tail.prev ; 
                actualtail.next = found;
                found.prev = actualtail;
                found.next = tail;
                tail.prev = found;
            }
        }  
        else {
            if(this.size == capacity){
                removeLRU();
            }
            addNode(key,value);
        } 
    }

    public void addNode(int key, int value) {
        Node prev = tail.prev;
        Node newNode = new Node(key,value);
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
        this.size++;
        map.put(key, newNode);
    }

    public void removeLRU() { 
        Node actualhead = head.next; 
        Node headnext = actualhead.next; 
        headnext.prev = head;
        head.next = headnext;
        map.remove(actualhead.k);
        this.size--;
    }
}

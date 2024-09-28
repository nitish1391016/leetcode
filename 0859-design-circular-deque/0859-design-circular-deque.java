class MyCircularDeque {
    Deque<Integer> q;
    int capacity;
    int currentCap = 0;
    public MyCircularDeque(int k) {
        q = new ArrayDeque<>(k);
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(currentCap >= capacity)
            return false;
        q.addFirst(value);
        ++currentCap;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(currentCap >= capacity)
            return false;
        q.addLast(value);
        ++currentCap;
        return true;
    }
    
    public boolean deleteFront() {
        if(currentCap <= 0)
            return false;
        q.removeFirst();
        --currentCap;
        return true;
    }
    
    public boolean deleteLast() {
        if(currentCap <= 0)
            return false;
        q.removeLast();
        --currentCap;
        return true;
    }
    
    public int getFront() {
        if(currentCap > 0)
            return q.peekFirst();
        return -1;
    }
    
    public int getRear() {
        if(currentCap > 0)
            return q.peekLast();
        return -1;

    }
    
    public boolean isEmpty() {
        return q.isEmpty();
    }
    
    public boolean isFull() {
        return q.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
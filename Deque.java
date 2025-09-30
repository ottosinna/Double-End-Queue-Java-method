public class Deque {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int cap;

    public Deque(int cap) {
        this.cap = cap;
        this.arr = new int[cap];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }
    public boolean isEmpty() { //O(1)
        return size == 0;
    }
    public boolean isFull() {//O(1)
        return size == cap;
    }

    public int size() { //O(1)
        return size;
    }

    public void clear() { //O(n) because we need to nullify all elements
        for (int i = 0; i< cap; i++) {
            arr[i] = 0;
        }
        front = -1;
        rear = -1;
        size = 0;
    }

    public void insertFront(int item) { //O(1) because we are just updating 
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front- 1 + cap) % cap;
        }
        arr[front] = item;
        size++;
    }

    public void insertBack(int item) { //O(1) same as insertFront
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear+ 1) % cap;
        }
        arr[rear] = item;
        size++;
    }

    public int removeFront() { //O(1) single array and updated
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        int item = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front+ 1) % cap;
        }
        size--;
        return item;
    }

    public int removeBack() { //O(1) similar to removeFront
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        int item = arr[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear- 1 +cap) % cap;
        }
        size--;
        return item;
    }

    public int getFront() { //O(1) catches access for one element
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return arr[front];
    }

    public int getRear() { //O(1) similar to getFront
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return arr[rear];
    }

    public int peekNth(int n) { // O(1) calculates index 
        if (n< 0 || n>= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int index = (front + n) % cap;
        return arr[index];
    }

    public void rotate(int k) { // O(n) because if full, we have to move all elements
        if (isEmpty() || k== 0) {
            return;
        }
        k = ((k% size) + size) % size;

        for (int i= 0; i< k; i++) {
            int item = removeBack();
            insertFront(item);
        }
    }
}

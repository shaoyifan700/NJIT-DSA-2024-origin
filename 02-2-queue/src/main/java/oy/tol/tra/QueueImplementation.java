package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {  
    private Object[] itemArray;
    private int capacity;
    private int front; 
    private int rear; 
    private int currentSize; 
    private int DEFAULT_QUEUE_SIZE = 10;

    public QueueImplementation() throws QueueAllocationException {//构造器      
      // TODO: call the constructor with size parameter with default size of 10.
    try {
        // 调用带有大小参数的构造函数，默认大小为10
        this.itemArray = new Object[DEFAULT_QUEUE_SIZE];
        } 
            catch (Exception e) {
        // 如果构造函数抛出异常，再次抛出异常
        throw new QueueAllocationException("Failed to allocate stack");
    }   
   }
   
   public QueueImplementation(int capacity) throws QueueAllocationException {
    if (capacity < 1) {
        throw new QueueAllocationException("Queue capacity must be at least 1");
    }
    this.capacity = capacity;
    this.itemArray = new Object[capacity];
    this.front = -1;
    this.rear = -1;
    this.currentSize = 0; 
   }

   public int capacity() {
    return this.capacity ;
   }

   public void enqueue(E element) throws QueueAllocationException, NullPointerException {
    /*if (element == null) {
        throw new NullPointerException("Cannot enqueue null element");
    }
    if (currentSize == capacity) {
        throw new QueueAllocationException("Queue is full");
        
    }
    if (currentSize == capacity){
        resize(capacity * 2);

    }
    if (front == -1) {
        front = 0;
    }
    rear = (rear + 1) % capacity;
    itemArray[rear] = element;
    currentSize++;
*/

    if (element == null) {
        throw new NullPointerException("Cannot enqueue null element");
    }
    if (currentSize == capacity) {
        resize(capacity * 2);
    }
    if (front == -1) {
        front = 0;
    }
    rear = (rear + 1) % capacity;
    itemArray[rear] = element;
    currentSize++;
}
   
   private void resize(int newCapacity) {
    // 创建新的数组
    Object[] newArray = new Object[newCapacity];
    // 将原数组中的元素复制到新数组中
    for (int i = 0; i < currentSize; i++) {
        newArray[i] = itemArray[(front + i) % capacity];
    }
    // 更新front和rear指针
    front = 0;
    rear = currentSize - 1;
    // 更新数组和容量
    itemArray = newArray;
    capacity = newCapacity;
    }
   public E dequeue() throws QueueIsEmptyException {
    
    if (isEmpty()) {
        throw new QueueIsEmptyException("Queue is empty");
    }
    E element = (E) itemArray[front];
    if (front == rear) {
        front = -1;
        rear = -1;
    } else {
        front = (front + 1) % capacity;
    }
    currentSize--;
    return element;
   }

   public E element() throws QueueIsEmptyException {
    if (isEmpty()) {
        throw new QueueIsEmptyException("Queue is empty");
    }
    return (E) itemArray[front];  
   }

   public int size(){

    return currentSize;
   }

   public boolean isEmpty(){
    return currentSize == 0;
   }

   public void clear() {
    itemArray = new Object[capacity];
    front = -1;
    rear = -1;
    currentSize = 0;
}

@Override
public String toString() {
    /*if (isEmpty()) {
        return "[]";
    }
    StringBuilder builder = new StringBuilder("[");
    int index = front;
    for (int i = 0; i < currentSize; i++) {
        builder.append(itemArray[index]);
        if (i != currentSize - 1) {
            builder.append(", ");
        }
        index = (index + 1) % capacity;
    }
    builder.append("]");
    return builder.toString();
    */
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        int index = front;
        for (int i = 0; i < currentSize; i++) {
            builder.append(itemArray[index]);
            if (i != currentSize - 1) {
                builder.append(", ");
            }
            index = (index + 1) % capacity;
        }
        builder.append("]");
        return builder.toString();
    }
}
                                   
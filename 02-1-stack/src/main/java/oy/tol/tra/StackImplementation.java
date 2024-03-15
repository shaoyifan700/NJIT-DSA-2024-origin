package oy.tol.tra;

import javax.crypto.spec.OAEPParameterSpec;

/**
 * An implementation of the StackInterface.
 * <p>
 * TODO: Students, implement this so that the tests pass.
 * Note that you need to implement construtor(s) for your concrete StackImplementation, which你需要为具体的栈实现实现构造函数
 * allocates the internal Object array for the Stack:*为栈分配内部对象数组:
 * - a default constructor, calling the StackImplementation(int size) with value of 10.默认构造函数,用10的值调用StackImplementation(int size)
 * - StackImplementation(int size), which allocates an array of Object's with size.*StackImplementation(int size)，分配一个大小为Object的数组
 *  -- remember to maintain the capacity and/or currentIndex when the stack is manipulated.
 */
public class StackImplementation<E> implements StackInterface<E> {

   private Object [] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10; 

   /**
    * Allocates a stack with a default capacity.
    * @throws StackAllocationException
    */
   public StackImplementation() throws StackAllocationException { //构造器
      // TODO: call the constructor with size parameter with default size of 10.
      try {
         // 调用带有大小参数的构造函数，默认大小为10
         this.itemArray = new Object[DEFAULT_STACK_SIZE];
         } 
            catch (Exception e) {
         // 如果构造函数抛出异常，再次抛出异常
         throw new StackAllocationException("Failed to allocate stack");
      }   
   }

   /** TODO: Implement so that
    * - if the size is less than 2, throw StackAllocationException
    * - if the allocation of the array throws with Java exception,分配数组若有问题则抛出异常
    *   throw StackAllocationException.
    * @param capacity The capacity of the stack.
    * @throws StackAllocationException If cannot allocate room for the internal array.
    */
   public StackImplementation(int capacity) throws StackAllocationException {
      if (capacity < 2) {
         throw new StackAllocationException("Stack capacity must be at least 2");
     }
     try {
         itemArray = new Object[capacity];
         this.capacity = capacity;
     } catch (Exception e) {
         throw new StackAllocationException("Failed to allocate room for the internal array");
     }
   }

   @Override
   public int capacity() {
      // TODO: Implement this
     return this.capacity ;
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      // TODO: Implement this
      if (currentIndex == capacity - 1) {
         // 如果堆栈已满，重新分配更多空间
         resizeArray();
     }
 
     if (element == null) {
         throw new NullPointerException("Cannot push null element into the stack");
     }
 
     currentIndex++;
     itemArray[currentIndex] = element;            
   }
   private void resizeArray() throws StackAllocationException {
      int newCapacity = capacity * 2; // 双倍扩容
      Object[] newArray = new Object[newCapacity];
  
      // 将现有元素复制到新数组中
      for (int i = 0; i < capacity; i++) {
          newArray[i] = itemArray[i];
      }
  
      itemArray = newArray; // 更新引用
      capacity = newCapacity; // 更新容量
  }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Cannot pop from an empty stack");
     } 
     E poppedItem = (E) itemArray[currentIndex];
     itemArray[currentIndex] = null; //置空
     currentIndex--;//下移
     return poppedItem;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty");
     }
     return (E) itemArray[currentIndex]; 
      }

   @Override
   public int size() {
      // TODO: Implement this
      return currentIndex + 1;   }

   @Override
   public void clear() {
      // TODO: Implement this
      currentIndex = -1;
      itemArray = new Object[DEFAULT_STACK_SIZE];
   }

   @Override
   public boolean isEmpty() {
      // TODO: Implement this
      return currentIndex == -1;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}

package oy.tol.tra;

import javax.crypto.spec.OAEPParameterSpec;

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
      if (element == null) {
         throw new NullPointerException("Cannot push null element into the stack");
     }
      if (currentIndex == capacity - 1) {
         // 如果堆栈已满，重新分配更多空间
         resizeArray();
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

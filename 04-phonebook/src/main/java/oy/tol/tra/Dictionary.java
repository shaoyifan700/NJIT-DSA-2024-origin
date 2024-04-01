package oy.tol.tra;

/**
 * A dictionary is a data structure containing key-value -pairs.
 * It is possible to add these pairs to the data structure, and then//可以添加pair
 * find values by key.
 * The actual concrete data structure that implements a Dictionary can
 * be either a linear array, hash table or binary search tree, for example.实现字典的实际数据结构可以
 *可以是线性数组、散列表或二叉查找树，
 */
//Dictionary接口
public interface Dictionary<K extends Comparable<K>, V> {
   /**
    * The types of phonebook implementations in this task.
    */
   public enum Type {
      /** Slow phonebook, already implemented for you. */
      SLOW,
      /** A hash table implementation. */
      HASHTABLE,
      /**
       * A binary search tree implementation. Not to be confused with binary search.
       */
      BST,
      /**
       * NONE means not yet implemented.
       * Change the value returned in `getType()` to HASHTABLE or BST when you are
       * ready to test your implementations!
       */
      NONE
   }

   /**
    * Decide on which type to implement, either hash table or binary search tree.
    * Then return the value.
    * 
    * @return The type of the phonebook implementation.
    */
   Type getType();

   /**
    * Ensures the (possible) internal array implementation has room for at least for {@code size}
    * number of elements. Otherwise, the internal array must be reallocated, grown. 
    * 
    * Calling this method removed all elements from the Dictionary internal array. Do not call
    * this method to reallocate and keep existing elements. Use a private method you implement for that.
    * This method is only used when you have created an empty Dictionary and then you need to ensure
    * a non-default capacity.
    *调用此方法将删除字典内部数组中的所有元素。不要调用
*此方法用于重新分配和保留现有元素。使用你为此实现的私有方法。
*仅当你创建了一个空字典，然后需要确保非默认容量时，才会使用此方法
*
    * Note that implementations not based on arrays (e.g. binary search tree, linked list)
    * do not need to reserve capacity. For these, this method does nothing.
    *注意，实现不基于数组(例如二叉查找树、链表)
*不需要预留容量。对于这些，这个方法什么都不做。
    * @param size The number of elements the Dictionary can hold without reallocation.
    * @throws OutOfMemoryError Throws if memory runs out.
    */
   void ensureCapacity(int size) throws OutOfMemoryError;

   /**
    * Adds a value for a key to the dictionary.
    *
    * The type K must implement hashCode, used in inserting and searching.
    *
    * Note that if a key already exists in the dictionary, the key-value pair
    * must be replaced with the new pair from the parameters. That is, the dictionary must not contain
    * duplicate keys. Note, however, that different keys may have the same hash value,
    * so always compare the elements with the same hash using `equals` to check if the
    * keys are actually the same.
    *注意，如果键在字典中已经存在，则键值对必须替换为参数中的新对,也就是说，字典不能包含
*重复的密钥然而，不同的键可能具有相同的哈希值，
*因此，总是使用`equals`比较具有相同哈希值的元素，以检查是否
*键实际上是一样的。
    * @param key The key value to use in adding elements. Must not be null.
    * @param value The associated value for the key. Must not be null;
    * @return Returns true if the key-value pair was added to the Dictionary.
    * @throws IllegalArgumentException Throws if key or value is null.
    * @throws OutOfMemoryError Throws if memory runs out.
    */
   boolean add(K key, V value) throws IllegalArgumentException, OutOfMemoryError;

   /**
    * Finds a value for the given key or returns null if not found.
    *
    * @param key The key to search. K must implement hashCode.
    * @return Returns the found value for the key or null if not found.
    * @throws IllegalArgumentException Throws if key to search is null.
    */
   V find(K key) throws IllegalArgumentException;

   /**
    * Returns the number of elements in the Dictionary.
    * @return The number of elements in the collection.
    */
   int size();

   /**
    * Gets status information about the phonebook.
    * In the fast implementations, returns statistics about how your data
    * structure works.
    * Read more from the README.md file.
    */
   String getStatus();

   /**
    * Returns the contents of the dictionary sorted by ascending key order in a new array.
    * The contents of the Dictionary's (possible) internal data structure are not to be
    * sorted nor changed in any way.
    * The array must contain only valid elements (not nulls, for example).
    * @return The contents of the Dictionary as an array sorted by key value.
    返回在新数组中按键升序排序的字典的内容。*/
   Pair<K,V> [] toSortedArray();

   /**
    * Compresses the internal array so that the array contains only
    * objects, and the size of the array is adjusted downwards accordingly.
    * For implementations having no internal array, this method does nothing.
    压缩内部数组，使数组只包含对象，并相应地向下调整数组的大小。
对于没有内部数组的实现，这个方法什么都不做。*/
   void compress() throws OutOfMemoryError;

}

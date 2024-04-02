package oy.tol.tra;
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.Comparator;

//import java.util.Comparator;
public class Algorithms {

private Algorithms(){

}

public static <T extends Comparable<T>> void sort(T [] array) {
    if(null == array){
        return;
    }
    int n = array.length;
         for (int i = 0; i < n - 1; i++) {
               for (int j = 0; j < n - i - 1; j++) {
                  if (array[j].compareTo(array[j + 1])>0) {
                     // 交换 grades[j] 和 grades[j + 1]
                     
                     swap(array,j,j+1);
                  }
               }
         }
    
}
    
public static <T extends Comparable<T>> void fastSort(T [] array) {
    if (array == null || array.length <= 1){
        return;
    }
    quickSort(array, 0, array.length-1); 
    
}

 public static <T> void reverse(T [] array) {
    if (array == null) {
        return;
    }
    int i = 0;
    int j = array.length - 1; // j 指向数组最后一个元素
    while (i < j) {
        swap(array, i, j);
        i++;
        j--;
    }
 }

 public static <T> void swap(T[] array,int first,int second){
    T temp = array[first];
    array[first] = array[second];
    array[second] = temp;
 }
 
public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
    int left = fromIndex;
    int right = toIndex ;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        int cmp = fromArray[mid].compareTo(aValue);

        if (cmp == 0) {
            return mid; // 找到了目标值，返回索引
        } else if (cmp < 0) {
            left = mid + 1; // 目标值在右侧
        } else {
            right = mid - 1; // 目标值在左侧
        }
    }

    return -1; // 没有找到目标值
}
    
public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }
 
    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        E pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    public static <T> int partitionByRule(T[] array, int count, Predicate<T> rule) {
        
        int index = 0;
        for (; index < count; index++) {
            if (rule.test(array[index])) {
                break;
            }
        }
        
        if (index >= count) {
            return count;
        }
        
        int nextIndex = index + 1;
     
        while (nextIndex != count) {
            if (!rule.test(array[nextIndex])) {
                swap(array, index, nextIndex);
                
                index++;
            }
            nextIndex++;
        }
        return index;
    }
//传入不同的比较器,就能实现升序排序与降序排序
    public static <T> void sortWithComparator(T[] array, Comparator<T> comparator) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    
    
}
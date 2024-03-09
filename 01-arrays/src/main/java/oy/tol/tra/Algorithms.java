package oy.tol.tra;
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
 public static <T> void reverse(T [] array) {
    if(array==null){
        return;
     }
    int i = 0;
    int j =  array.length % 2 ;  //奇数,j = 1,偶数 j = 0
    if( j == 1 ) {
        while (i <= array.length/2) {
            swap( array,  i,  array.length-i-1);
            i++;
        }
    }
    if( j == 0 ) {
        while (i <= array.length/2 - 1) {
        
            swap(array,i,array.length-i-1);
            i++;
        }
        
    }
 }
 public static <T> void swap(T[] array,int first,int second){
    T temp = array[first];
    array[first] = array[second];
    array[second] = temp;
 }

}